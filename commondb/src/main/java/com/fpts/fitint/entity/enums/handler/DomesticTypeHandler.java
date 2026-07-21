package com.fpts.fitint.entity.enums.handler;

import com.fpts.fitint.entity.enums.Domestic;
import com.fpts.fitint.entity.enums.helpers.BaseCodedEnumTypeHandler;

import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Domestic.class)
public class DomesticTypeHandler extends BaseCodedEnumTypeHandler<Domestic> {
    public DomesticTypeHandler() {
        super(Domestic.class);
    }
}
