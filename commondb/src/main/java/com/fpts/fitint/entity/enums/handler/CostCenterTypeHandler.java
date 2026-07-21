package com.fpts.fitint.entity.enums.handler;

import com.fpts.fitint.entity.enums.CostCenter;
import com.fpts.fitint.entity.enums.helpers.BaseCodedEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(CostCenter.class)
public class CostCenterTypeHandler extends BaseCodedEnumTypeHandler<CostCenter> {
    public CostCenterTypeHandler() {
        super(CostCenter.class);
    }
}
