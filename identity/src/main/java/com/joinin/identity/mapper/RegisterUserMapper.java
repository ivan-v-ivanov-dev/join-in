package com.joinin.identity.mapper;

import com.join_in.kafka_models.messages.RegisterNewUser;
import com.joinin.identity.model.RegisterUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterUserMapper {

    RegisterUser fromRegisterNewUsertoRegisterUser(RegisterNewUser message);

}
