package com.fpts.fitint.entity.enums;

import com.fpts.fitint.entity.enums.helpers.CodedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CostCenter implements CodedEnum {
    ALL(-1,"ALL"),
    HANOI(1,"Hà Nội"),
    HOCHIMINH(2,"Hồ Chí Minh"),
    DANANG(3,"Đà Nẵng");

    private final int code;
    private final String deString;

    @Override
    public String getDescription() {
        return this.deString;
    }
}
