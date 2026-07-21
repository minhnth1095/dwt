package com.fpts.fitint.kafka.Producer;

import com.fpts.fitint.config.KafkaClusterProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    private final KafkaClusterProperties properties;

    public KafkaProducerConfig(KafkaClusterProperties properties) {
        this.properties = properties;
    }

    //===== account ========
    @Bean(name = "accountProducerFactory")
    public ProducerFactory<String, Object> accountProducerFactory() {
        KafkaClusterProperties.ClusterConfig config = properties.getClusters().get("account");
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
        configProps.put(ProducerConfig.ACKS_CONFIG, "all");
        configProps.put(ProducerConfig.RETRIES_CONFIG, 0);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name="accountKafkaTemplate")
    public KafkaTemplate<String, Object> accountKafkaTemplate(
        @Qualifier("accountProducerFactory") ProducerFactory<String, Object> producerFactory)
    {
        return new KafkaTemplate<>(producerFactory);
    }

    // ===== Cluster: accountFu =====
    @Bean(name = "accountFuProducerFactory")
    public ProducerFactory<String, Object> accountFuProducerFactory() {
        KafkaClusterProperties.ClusterConfig config = properties.getClusters().get("accountFu");

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean(name = "accountFuKafkaTemplate")
    public KafkaTemplate<String, Object> accountFuKafkaTemplate(
            @Qualifier("accountFuProducerFactory") ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
