package com.joinin.gateway.mapper;

import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.join_in.common_models.ProfileRpGatewayService;
import com.join_in.common_models.ProfileRpProfileService;
import com.join_in.common_models.ProfileRpRelationshipService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileRpGatewayService fromProfileRpProfileServicetoProfileRpGatewayService(ProfileRpProfileService profileRpProfileService);

    List<ProfileFriendsRpGatewayService> fromListProfileRpRelationshipServicetoListProfileFriendsRpGatewayService(List<ProfileRpRelationshipService> friendsProfiles);
}
