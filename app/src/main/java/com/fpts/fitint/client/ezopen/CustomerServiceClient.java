package com.fpts.fitint.client.ezopen;

import com.fpts.fitint.client.dto.CustomerInfoDto;
import com.fpts.fitint.client.properties.ExternalServiceProperties;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import javax.naming.ServiceUnavailableException;
import java.util.Map;

@Service
public class CustomerServiceClient {
    private final RestClient restClient;
    private final Map<String, String> paths;
    public CustomerServiceClient(@Qualifier("ezopenRestClient") RestClient restClient, ExternalServiceProperties externalServiceProperties) {
        this.restClient = restClient;
        this.paths = externalServiceProperties.getServices().get("ezopen").getPaths();
    }

    public CustomerInfoDto getCustomerInfo(String clientCode){
        RestClient.ResponseSpec retrieve = restClient.get()
                .uri(paths.get("customer-info"), clientCode)
                .retrieve();
        retrieve.onStatus(HttpStatusCode::is4xxClientError, (_, _) -> {
            try {
                throw new NotFoundException("Customer not found");
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        retrieve.onStatus(HttpStatusCode::is5xxServerError, (_, _) -> {
            try {
                throw new ServiceUnavailableException("ERR");
            } catch (ServiceUnavailableException e) {
                throw new RuntimeException(e);
            }
        });
        return retrieve
                .body(CustomerInfoDto.class);
    }
}
