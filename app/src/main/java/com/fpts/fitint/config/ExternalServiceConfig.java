package com.fpts.fitint.config;


import com.fpts.fitint.client.properties.ExternalServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(ExternalServiceProperties.class)
public class ExternalServiceConfig {
    @Bean("ezopenRestClient")
    public RestClient ezopenRestClient(ExternalServiceProperties properties) {
        var config = properties.getServices().get("ezopen");
        return RestClient.builder()
                .baseUrl(config.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
