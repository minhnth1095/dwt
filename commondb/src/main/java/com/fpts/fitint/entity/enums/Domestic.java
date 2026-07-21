package com.fpts.fitint.entity.enums;

import com.fpts.fitint.entity.enums.helpers.CodedEnum;
import lombok.Getter;

@Getter
public enum Domestic implements CodedEnum {
    DOMESTIC(1,"NƯỚC NGOÀI"),
    INTERNATIONAL(0,"TRONG NƯỚC"),
    UNKNOWN(2,"UNKNOWN");
    private final int code;
    private final String description;

    Domestic(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
