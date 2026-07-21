package com.fpts.fitint.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfoDto {
    @JsonProperty("acustaccount")
    private String custAccount;

    @JsonProperty("aaccstate")
    private int accState;

    @JsonProperty("aorgtype")
    private int orgType;

    @JsonProperty("atypeacc")
    private int typeAcc;

    @JsonProperty("adomestic")
    private int domestic;

    @JsonProperty("aname")
    private String name;

    @JsonProperty("alongname")
    private String longName;

    @JsonProperty("aaddresscost")
    private int addressCost;

    @JsonProperty("amobile")
    private String mobile;

    @JsonProperty("aemail")
    private String email;

    @JsonProperty("ATRADE_EZFUTURES")
    private int ezFutures;

    @JsonProperty("ARESULT_SMS")
    private String sms;

    @JsonProperty("ASMS_FEE_FLUCTUATIONS")
    private int smsTransaction;

    @JsonProperty("aidentifynumber")
    private String identifyNumber;

    @JsonProperty("aplaceissue")
    private String placeIssue;

    @JsonProperty("adateissue")
    private String dateIssue;

    @JsonProperty("blockinfo")
    private BlockInfo blockInfo;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BlockInfo {

        @JsonProperty("blockIdentify")
        private int blockIdentify;

        @JsonProperty("blockMapping")
        private int blockMapping;
    }
}

