package com.joinin.mvc.mappers;

import com.join_in.common_models.RegisterUserMVCRq;
import com.joinin.mvc.model.RegisterRq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterUserMapper {

    RegisterUserMVCRq fromRegisterRqtoRegisterUserMVCRq(RegisterRq registerRq);
}
