package com.fpts.fitint.mapper;

import com.fpts.fitint.dto.payment.PaymentAddParam;
import com.fpts.fitint.entity.payment.Payment;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {
    List<Payment> getPaymentsByClientCode(@Param("clientCode") String clientCode);
    void insertPayment(PaymentAddParam params);
    Payment getPaymentByRequestId(@Param("requestId") String requestId);
}
