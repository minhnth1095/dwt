package com.fpts.fitint.dto.Payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
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
    private Integer status;
    private Integer domestic;
    private Integer costCenter;
    private Integer channel;
    private Date transDate;
    private String createBy;
    private String approveBy;
    private String longName;
    private String requestId;
}
