package com.social.profile.adapter;

import com.social.model.dto.ProfileRp;
import com.social.profile.model.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiGatewayAdapter {
    ProfileRp fromProfileToProfileGatewayRp(Profile profile, ProfileRp profileRp);
}