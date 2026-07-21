package com.fpts.fitint.entity.enums.helpers;

public class EnumUtils {
    public static <T extends Enum<T> & CodedEnum> T fromCode(Class<T> enumClass, int code) {
        for (T constant : enumClass.getEnumConstants()) {
            if (constant.getCode() == code) {
                return constant;
            }
        }
        throw new IllegalArgumentException("Unknown code " + code + " for " + enumClass.getSimpleName());
    }
}
