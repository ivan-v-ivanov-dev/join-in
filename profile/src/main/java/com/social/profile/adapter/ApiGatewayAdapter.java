package com.social.profile.adapter;

import com.social.model.dto.ProfileRp;
import com.social.profile.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApiGatewayAdapter {
    @Mapping(source = "profile.identity", target = "identity")
    @Mapping(source = "profile.firstName", target = "firstName")
    @Mapping(source = "profile.lastName", target = "lastName")
    @Mapping(source = "profile.email", target = "email")
    @Mapping(source = "profile.aboutMe", target = "aboutMe")
    @Mapping(source = "profile.mobile", target = "mobile")
    @Mapping(source = "profile.city", target = "city")
    @Mapping(source = "profile.country", target = "country")
    @Mapping(source = "profile.birthDate", target = "birthDate")
    @Mapping(source = "profile.gender", target = "gender")
    @Mapping(source = "profile.joined", target = "joined")
    @Mapping(source = "profile.status", target = "status")
    @Mapping(source = "profile.website", target = "website")
    @Mapping(source = "profile.hobbies", target = "hobbies")
    ProfileRp fromProfileToProfileGatewayRp(Profile profile, ProfileRp profileRp);
}
