package com.joinin.mvc.mappers;

import com.join_in.common_models.GroupRpGatewayService;
import com.joinin.mvc.model.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    Group fromGroupRpGatewayServicetoGroup(GroupRpGatewayService groupRpGatewayService);
}
