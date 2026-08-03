package com.joinin.gateway.mapper;

import com.join_in.common_models.GroupRpGatewayService;
import com.join_in.common_models.GroupRpGroupService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupRpGatewayService fromGroupRpGroupServicetoGroupRpGatewayService(GroupRpGroupService groupRpGroupService);
}
