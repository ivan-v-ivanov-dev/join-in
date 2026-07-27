package com.joinin.mvc.mappers;

import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.joinin.mvc.model.Friends;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FriendsMapper {

    List<Friends> fromListProfileFriendsRpGatewayServicetoListFriends(List<ProfileFriendsRpGatewayService> friends);
}
