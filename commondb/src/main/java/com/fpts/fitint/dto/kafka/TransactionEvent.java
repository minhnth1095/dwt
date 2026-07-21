package com.fpts.fitint.dto.kafka;

import com.fpts.fitint.entity.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionEvent implements Serializable {
    private LocalDateTime createDate;
    private String refId;
    private String clientCode;
    private int businessType;
    private String desc;
    private String source;
    private LocalDateTime tranDate;
    private String subId;
    private Status status;
    private byte updateType;
    private long cashAmount;
    private int productType;
    private long adhoc;
    private Object additionalData;
}
