package com.joinin.mvc.mappers;

import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.joinin.mvc.model.Friends;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendsMapper {

    Friends fromProfileFriendsRpGatewayServicetoFriends(ProfileFriendsRpGatewayService friend);
}
