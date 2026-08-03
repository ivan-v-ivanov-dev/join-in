package com.joinin.group.mapper;

import com.join_in.common_models.GroupRpGroupService;
import com.joinin.group.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupsMapper {
    @Mapping(target = "identity", source = "group.identity")
    @Mapping(target = "name", source = "group.name")
    @Mapping(target = "description", source = "group.description")
    @Mapping(target = "image", source = "image")
    GroupRpGroupService fromGrouptoGroupRpGroupService(Group group, String image);
}
