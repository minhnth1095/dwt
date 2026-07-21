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
    private String requestId;
    private String bankGateway;
    private String clientCode;
    private BigDecimal cashAmount;
    private String description;
    private String clientName;
    private String fptsAccNum;
    private LocalDateTime transDate;
    private String bankCode;
    private String createdBy;
    private Domestic domestic;
    private CostCenter costCenter;
    private Channel channel;
    private String transRef;
    private String longName;
}
