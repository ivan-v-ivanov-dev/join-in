package com.social.mvc.adapter;

import com.social.model.dto.RegisterUserRq;
import com.social.mvc.model.Register;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAdapter {

    public RegisterUserRq fromRegisterToRegisterUserRq(Register register) {
        return RegisterUserRq.builder()
                .email(register.getEmail())
                .firstName(register.getFirstName())
                .lastName(register.getLastName())
                .email(register.getEmail())
                .password(register.getPassword()).build();
    }
}
