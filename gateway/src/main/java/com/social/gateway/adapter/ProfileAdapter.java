package com.social.gateway.adapter;

import com.social.model.dto.ProfileGatewayRp;
import com.social.model.dto.ProfileRp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileAdapter {

    ProfileGatewayRp fromProfileRpToProfileGatewayRp(ProfileRp byIdentity);
}
