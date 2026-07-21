package com.fpts.fitint.entity.enums;

import com.fpts.fitint.entity.enums.helpers.CodedEnum;

public enum PaymentBType implements CodedEnum {

    DEPOSIT(29,"DEPOSIT"),
    DEPOSIT_INTERNAL(30,"DEPOSIT_INTERNAL");

    private final int code;
    private final String description;

    PaymentBType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
