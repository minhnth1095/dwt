package com.fpts.fitint.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaClusterProperties  {
    private Map<String, ClusterConfig> clusters = new HashMap<>();

    public Map<String, ClusterConfig> getClusters() { return clusters; }
    public void setClusters(Map<String, ClusterConfig> clusters) { this.clusters = clusters; }
    public static class ClusterConfig {
        private String bootstrapServers;
        private Map<String, String> topics = new HashMap<>();

        public String getBootstrapServers() { return bootstrapServers; }
        public void setBootstrapServers(String bootstrapServers) { this.bootstrapServers = bootstrapServers; }

        public Map<String, String> getTopics() { return topics; }
        public void setTopics(Map<String, String> topics) { this.topics = topics; }
    }

}
