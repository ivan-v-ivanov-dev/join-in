package com.joinin.gateway.mapper;

import com.join_in.common_models.ProfileRpGatewayService;
import com.join_in.common_models.ProfileRpProfileService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileRpGatewayService fromProfileRpProfileServicetoProfileRpGatewayService(ProfileRpProfileService profileRpProfileService);
}
