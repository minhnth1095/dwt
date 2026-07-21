package com.fpts.fitint.entity.enums.handler;

import com.fpts.fitint.entity.enums.Status;
import com.fpts.fitint.entity.enums.helpers.BaseCodedEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Status.class)
public class StatusTypeHandler extends BaseCodedEnumTypeHandler<Status> {
    public StatusTypeHandler(){
        super(Status.class);
    }
}
