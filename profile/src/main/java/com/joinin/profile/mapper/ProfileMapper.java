package com.joinin.profile.mapper;

import com.join_in.common_models.ProfileRpProfileService;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.joinin.profile.models.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "identity", source = "identity")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "aboutMe", constant = "Add information about yourself")
    @Mapping(target = "mobile", constant = "Add mobile number")
    @Mapping(target = "address", constant = "Add address")
    @Mapping(target = "birthDate", constant = "Add birth date")
    @Mapping(target = "birthYear", constant = "Add birth year")
    @Mapping(target = "birthplace", constant = "Add birthplace")
    @Mapping(target = "livesIn", constant = "Add place where you live")
    @Mapping(target = "gender", constant = "Add gender")
    @Mapping(target = "interestedIn", constant = "Add who you are interested in")
    @Mapping(target = "language", constant = "Add languages")
    @Mapping(target = "joined", constant = "Add joined date")
    @Mapping(target = "status", constant = "Add relationship status")
    @Mapping(target = "phoneNumber", constant = "Add phone number")
    @Mapping(target = "website", constant = "Add website")
    @Mapping(target = "socialLink", constant = "Add social link")
    @Mapping(target = "hobbies", constant = "Add hobbies")
    @Mapping(target = "work", constant = "Add workplace")
    @Mapping(target = "professionalSkills", constant = "Add professional skills")
    @Mapping(target = "college", constant = "Add college")
    @Mapping(target = "currentCity", constant = "Add current city")
    @Mapping(target = "hometown", constant = "Add hometown")
    @Mapping(target = "otherPlacesLived", constant = "Add other places lived")
    Profile fromNewRegisteredUserInfotoProfile(NewRegisteredUserInfo newRegisteredUserInfo);

    @Mapping(target = "email", source = "email")
    ProfileRpProfileService fromProfiletoProfileRpProfileService(Profile profile, String email);
}
