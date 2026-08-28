package com.joinin.gateway.mapper;

import com.join_in.common_models.*;
import com.join_in.kafka_models.messages.UpdateProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileRpGatewayService fromProfileRpProfileServicetoProfileRpGatewayService(ProfileRpProfileService profileRpProfileService);

    ProfileFriendsRpGatewayService fromProfileRpRelationshipServicetoProfileFriendsRpGatewayService(ProfileRpRelationshipService friend);

    @Mapping(target = "identity", source = "identity")
    @Mapping(target = "firstName", source = "editProfileGatewayRq.firstName")
    @Mapping(target = "lastName", source = "editProfileGatewayRq.lastName")
    @Mapping(target = "aboutMe", source = "editProfileGatewayRq.aboutMe")
    @Mapping(target = "mobile", source = "editProfileGatewayRq.mobile")
    @Mapping(target = "address", source = "editProfileGatewayRq.address")
    @Mapping(target = "birthDate", source = "editProfileGatewayRq.birthDate")
    @Mapping(target = "birthYear", source = "editProfileGatewayRq.birthYear")
    @Mapping(target = "birthplace", source = "editProfileGatewayRq.birthplace")
    @Mapping(target = "livesIn", source = "editProfileGatewayRq.livesIn")
    @Mapping(target = "gender", source = "editProfileGatewayRq.gender")
    @Mapping(target = "interestedIn", source = "editProfileGatewayRq.interestedIn")
    @Mapping(target = "language", source = "editProfileGatewayRq.language")
    @Mapping(target = "joined", source = "editProfileGatewayRq.joined")
    @Mapping(target = "status", source = "editProfileGatewayRq.status")
    @Mapping(target = "phoneNumber", source = "editProfileGatewayRq.phoneNumber")
    @Mapping(target = "website", source = "editProfileGatewayRq.website")
    @Mapping(target = "socialLink", source = "editProfileGatewayRq.socialLink")
    @Mapping(target = "hobbies", source = "editProfileGatewayRq.hobbies")
    @Mapping(target = "work", source = "editProfileGatewayRq.work")
    @Mapping(target = "professionalSkills", source = "editProfileGatewayRq.professionalSkills")
    @Mapping(target = "college", source = "editProfileGatewayRq.college")
    @Mapping(target = "currentCity", source = "editProfileGatewayRq.currentCity")
    @Mapping(target = "hometown", source = "editProfileGatewayRq.hometown")
    @Mapping(target = "otherPlacesLived", source = "editProfileGatewayRq.otherPlacesLived")
    UpdateProfile fromEditProfileGatewayRqtoUpdateProfile(String identity, EditProfileGatewayRq editProfileGatewayRq);
}
