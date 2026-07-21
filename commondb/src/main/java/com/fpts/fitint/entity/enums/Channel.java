package com.fpts.fitint.entity.enums;

import com.fpts.fitint.entity.enums.helpers.CodedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Channel implements CodedEnum {
    INTERNAL(1,"INTERNAL"),
    ONLINE(2,"ONLINE");

    private final int code;
    private final String description;
}
