package com.social.mvc.adapter;

import com.social.model.dto.RegisterUserRq;
import com.social.mvc.model.RegisterRq;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAdapter {

    public RegisterUserRq fromRegisterToRegisterUserRq(RegisterRq registerRq) {
        return RegisterUserRq.builder()
                .email(registerRq.getEmail())
                .firstName(registerRq.getFirstName())
                .lastName(registerRq.getLastName())
                .email(registerRq.getEmail())
                .password(registerRq.getPassword()).build();
    }
}
