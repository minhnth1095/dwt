package com.fpts.fitint.client.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ConfigurationProperties(prefix = "external-services")
public class ExternalServiceProperties {

    private Map<String, ServiceConfig> services = new HashMap<>();

    @Setter
    @Getter
    public static class ServiceConfig {
        private String baseUrl;
        private Map<String, String> paths = new HashMap<>();

    }
}