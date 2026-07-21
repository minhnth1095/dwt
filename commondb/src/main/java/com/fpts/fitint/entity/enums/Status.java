package com.fpts.fitint.entity.enums;

import com.fpts.fitint.entity.enums.helpers.CodedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status implements CodedEnum {
    ALL(-1,"ALL"),
    PENDING(0, "PENDING"),
    PENDING_RELEASE(1, "PENDING_RELEASE"),
    RELEASED(2, "RELEASED"),
    PROCESSING(5, "PROCESSING"),
    AUTO_RELEASE(33, "AUTO_RELEASE"),
    MANUAL_RELEASE(34, "MANUAL_RELEASE"),
    ACCOUNT_NOT_EXISTS(21, "ACCOUNT_NOT_EXISTS"),
    ERROR(-5, "ERROR"),
    REVERT(-2, "REVERT"),
    CANCELLED(-12, "CANCELLED"),
    CUT_OF_TIME(26, "CUT_OF_TIME");


    private final int code;
    private final String displayName;

    @Override
    public String getDescription() {
        return "";
    }
}
