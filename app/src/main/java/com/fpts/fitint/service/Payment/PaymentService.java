package com.fpts.fitint.service.Payment;

import com.fpts.fitint.client.ezopen.CustomerServiceClient;
import com.fpts.fitint.config.LogExecution;
import com.fpts.fitint.dto.Payment.PaymentEvent;
import com.fpts.fitint.dto.Payment.PaymentRequest;
import com.fpts.fitint.dto.payment.PaymentAddParam;
import com.fpts.fitint.entity.enums.Channel;
import com.fpts.fitint.entity.enums.Status;
import com.fpts.fitint.event.AccountEventPublisher;
import com.fpts.fitint.mapper.Payment.PaymentRequestConverter;
import com.fpts.fitint.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRequestConverter converter;
    private final AccountEventPublisher eventPublisher;
    private final CustomerServiceClient customerServiceneClient;
    public PaymentService(PaymentMapper paymentMapper, PaymentRequestConverter converter, AccountEventPublisher eventPublisher, CustomerServiceClient customerServiceneClient) {
        this.paymentMapper = paymentMapper;
        this.converter = converter;
        this.eventPublisher = eventPublisher;
        this.customerServiceneClient = customerServiceneClient;
    }

    @LogExecution
    public void createPayment(PaymentRequest request) {
        var payment = paymentMapper.getPaymentByRequestId(request.getRequestId());
        if (payment != null) {
            log.warn("Payment already exists for requestId: " + request.getRequestId());
            return;
        }
        var customer = customerServiceneClient.getCustomerInfo(request.getClientCode());
        if(customer.getAccState() != 2)
            return;


        PaymentAddParam param = converter.toAddParam(request);
        paymentMapper.insertPayment(param);
        var source = request.getChannel() == Channel.INTERNAL ? "NOPTIEN" : "NOPTIEN_BNKGTW";
        var event = PaymentEvent.builder()
                .createDate(LocalDateTime.now())
                .refId(request.getRequestId())
                .clientCode(request.getClientCode())
                .businessType(30)
                .desc(request.getDescription())
                .source(source)
                .tranDate(request.getTransDate())
                .cashAmount(request.getCashAmount())
                .status(Status.PENDING)
                .subId(request.getRequestId())
                .updateType((byte)1)
                .productType(0)
                .additionalData(null)
                .build();
        eventPublisher.publishAccountCashEvent(event);
    }
}
