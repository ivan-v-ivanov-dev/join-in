package com.social.authentication.service;

import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.RegisterService;
import com.social.authentication.util.PasswordEncoderImpl;
import com.social.authentication.util.contracts.IdentityGenerator;
import com.social.authentication.util.contracts.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IdentityGenerator identityGenerator;

    public RegisterServiceImpl(UserRepository userRepository,
                               PasswordEncoderImpl passwordEncoder,
                               IdentityGenerator identityGenerator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.identityGenerator = identityGenerator;
    }

}
