package com.fpts.fitint.event;

import com.fpts.fitint.config.KafkaClusterProperties;
import com.fpts.fitint.dto.Payment.PaymentEvent;
import com.fpts.fitint.entity.enums.Status;
import com.fpts.fitint.util.CommonUtils;
import org.apache.kafka.common.metrics.Stat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public void publishAccountCashEvent(PaymentEvent mesage){
        var message = PaymentEvent.builder()
                .createDate(mesage.getCreateDate())
                .refId(mesage.getRefId())
                .clientCode(mesage.getClientCode())
                .businessType(mesage.getBusinessType())
                .desc(mesage.getDesc())
                .source(mesage.getSource())
                .tranDate(mesage.getTranDate().toLocalDate().equals(CommonUtils.now().toLocalDate()) ? CommonUtils.now() : mesage.getTranDate())
                .cashAmount(mesage.getStatus() == Status.REVERT ? mesage.getCashAmount().negate() : mesage.getCashAmount())
                .additionalData(mesage.getAdditionalData())
                .status(mesage.getStatus())
                .subId(mesage.getStatus() == Status.REVERT ? mesage.getSubId() : null).build();

        kafkaTemplate.send(getTopic("account","accountTopic"),mesage);
    }

    private String getTopic(String cluster, String topicKey) {
        return properties.getClusters().get(cluster).getTopics().get(topicKey);
    }
}
