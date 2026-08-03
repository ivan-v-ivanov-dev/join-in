package com.joinin.mvc.mappers;

import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.joinin.mvc.model.Friend;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendsMapper {

    Friend fromProfileFriendsRpGatewayServicetoFriends(ProfileFriendsRpGatewayService friend);
}
