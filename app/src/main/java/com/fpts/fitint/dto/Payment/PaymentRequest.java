package com.fpts.fitint.dto.Payment;

import com.fpts.fitint.entity.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PaymentRequest {
    @NotBlank(message = "transactionId is required")
    private String transactionId;

    @NotBlank(message = "bankGateway is required")
    private String bankGateway;

    private String tranRef;

    @NotBlank(message = "clientCode is required")
    private String clientCode;

    private String clientName;

    @NotNull(message = "amount is required")
    @Positive(message = "amount must be positive")
    private BigDecimal amount;

    @NotBlank(message = "fptsAcc is required")
    private String fptsAcc;

    private String bankCode;
    private String branch;
    private String description;
    private Status status;
    private Domestic domestic;
    private CostCenter costCenter;
    private Channel channel;
    private LocalDateTime transDate;
    private String createBy;
    private String approveBy;
    private String longName;
    private String requestId;
    private PaymentBType businessType;
    private Integer productType;
    private Object additionalData;
}
