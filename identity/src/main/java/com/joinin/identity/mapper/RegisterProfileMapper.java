package com.joinin.identity.mapper;

import com.join_in.kafka_models.messages.RegisterNewUser;
import com.joinin.identity.model.RegisterProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterProfileMapper {

    RegisterProfile fromRegisterNewUsertoRegisterProfile(RegisterNewUser message);

}
