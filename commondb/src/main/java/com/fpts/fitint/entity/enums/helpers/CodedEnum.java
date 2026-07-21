package com.fpts.fitint.entity.enums.helpers;

import com.fasterxml.jackson.annotation.JsonValue;

public interface CodedEnum {
    @JsonValue
    int getCode();
    String getDescription();
}
