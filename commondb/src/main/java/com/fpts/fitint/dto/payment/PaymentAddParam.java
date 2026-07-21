package com.fpts.fitint.dto.payment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentAddParam {
    private String ptransactionid;
    private String pbankgateway;
    private String ptranref;
    private String pclientcode;
    private String pclientname;
    private BigDecimal pcashamt;
    private String pfptsacc;
    private String pbankcode;
    private String pbranch;
    private String pdescription;
    private Integer pstatus;
    private Integer pdomestic;
    private Integer pcostcenter;
    private Integer pchannel;
    private java.util.Date ptransdate;
    private java.util.Date pcreatedate;
    private String pcreateby;
    private String papproveby;
    private String plongname;
    private Integer pstatusacc = 0;
    private Integer ppartition = -1;
    private Integer poffset = -1;
    private String prequestid;
    private Integer pbankpartition = -1;
    private Integer pbankoffset = -1;
    private Integer pimportnova = -1;
    private Integer pcot = -1;

    // OUT params — bắt buộc có setter để MyBatis ghi ngược giá trị vào
    private Integer preturncode;
    private String preturnMess;
}
