package com.fpts.fitint.dto.Payment;

import com.fpts.fitint.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent  implements Serializable {
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
