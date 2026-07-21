package com.fpts.fitint.service.Payment;

import com.fpts.fitint.dto.Payment.PaymentEvent;
import com.fpts.fitint.dto.Payment.PaymentRequest;
import com.fpts.fitint.dto.kafka.TransactionEvent;
import com.fpts.fitint.dto.payment.PaymentAddParam;
import com.fpts.fitint.event.AccountEventPublisher;
import com.fpts.fitint.mapper.Payment.PaymentRequestConverter;
import com.fpts.fitint.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRequestConverter converter;
    private final AccountEventPublisher eventPublisher;
    public PaymentService(PaymentMapper paymentMapper, PaymentRequestConverter converter, AccountEventPublisher eventPublisher) {
        this.paymentMapper = paymentMapper;
        this.converter = converter;
        this.eventPublisher = eventPublisher;
    }

    public void createPayment(PaymentRequest request) {
        var payment = paymentMapper.getPaymentById(request.getRequestId());
        if (payment != null) {
            throw new RuntimeException("Payment already exists: " + request.getRequestId());
        }
        PaymentAddParam param = converter.toAddParam(request);
        paymentMapper.insertPayment(param);
        var event = PaymentEvent.builder()
                .createDate(LocalDateTime.now())
                .tranDate(LocalDateTime.now())
                .refId(request.getRequestId())
                .clientCode(request.getClientCode());

    }
}
