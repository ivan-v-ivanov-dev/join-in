package com.joinin.mvc.mappers;

import com.join_in.common_models.ProfileRpGatewayService;
import com.joinin.mvc.model.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile fromProfileRpGatewayServicetoProfile(ProfileRpGatewayService profileRpGatewayService);
}
