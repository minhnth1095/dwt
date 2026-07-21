package com.fpts.fitint.entity.enums.handler;

import com.fpts.fitint.entity.enums.Channel;
import com.fpts.fitint.entity.enums.helpers.BaseCodedEnumTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Channel.class)
public class ChannelTypeHandler extends BaseCodedEnumTypeHandler<Channel> {
    public ChannelTypeHandler() {
        super(Channel.class);
    }
}
