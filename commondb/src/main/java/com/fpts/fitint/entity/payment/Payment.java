package com.fpts.fitint.entity.payment;

import com.fpts.fitint.entity.enums.Channel;
import com.fpts.fitint.entity.enums.CostCenter;
import com.fpts.fitint.entity.enums.Domestic;
import com.fpts.fitint.entity.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
    private String transaction;
    private String bankGateway;
    private String transRef;
    private String clientCode;
    private String clientName;
    private Long cashAmount;
    private String fptsAccountNumber;
    private String bankCode;
    private String branch;
    private String description;
    @Enumerated
    private Status status;
    private Domestic domestic;
    private CostCenter costCenter;
    private Channel channel;
    private Date transDate;
    private Date createDate;
    private String createdBy;
    private Date approveDate;
    private String approveUser;
    private String impNova;
    private Date impDate;
    private String comment;
    private Integer statusAcc;
    private String longName;
    private String partition;
    private Integer offset;
    private String requestId;
    private Integer bankPartition;
    private Integer bankOffset;
    private Integer cot;
}
