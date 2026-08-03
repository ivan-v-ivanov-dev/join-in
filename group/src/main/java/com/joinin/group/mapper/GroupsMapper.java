package com.joinin.group.mapper;

import com.join_in.common_models.GroupRpGroupService;
import com.joinin.group.model.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupsMapper {

    GroupRpGroupService fromGrouptoGroupRpGroupService(Group group);
}
