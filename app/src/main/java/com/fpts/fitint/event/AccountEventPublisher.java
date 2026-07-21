package com.fpts.fitint.event;

import com.fpts.fitint.config.KafkaClusterProperties;
import com.fpts.fitint.dto.kafka.TransactionEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaTemplate<String, Object> kafkaFuTemplate;
    private final KafkaClusterProperties properties;

    public AccountEventPublisher(
            @Qualifier("accountKafkaTemplate") KafkaTemplate<String, Object> accountKafkaTemplate,
            @Qualifier("accountFuKafkaTemplate") KafkaTemplate<String, Object> kafkaFuTemplate,
            KafkaClusterProperties properties)
    {
        this.kafkaTemplate = accountKafkaTemplate;
        this.kafkaFuTemplate = kafkaFuTemplate;
        this.properties = properties;
    }

    public void publishAccountCashEvent(TransactionEvent mesage){
        kafkaTemplate.send(getTopic("account","accountTopic"),mesage);
    }

    private String getTopic(String cluster, String topicKey) {
        return properties.getClusters().get(cluster).getTopics().get(topicKey);
    }
}
