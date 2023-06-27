package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.model.dto.RegisterDto;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.RegisterService;
import com.social.authentication.util.PasswordEncoderImpl;
import com.social.authentication.util.contracts.IdentityGenerator;
import com.social.authentication.util.contracts.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.social.authentication.service.constants.ExceptionConstants.USER_EMAIL_IS_ALREADY_IN_USE;

@Service
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

    @Override
    public void register(RegisterDto registerDto) {
        if (userRepository.findByEmail(registerDto.getEmail()) != null) {
            throw new IllegalArgumentException(USER_EMAIL_IS_ALREADY_IN_USE);
        }

        User user = User.builder()
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .identity(identityGenerator.generate(registerDto.getEmail()))
                .build();

        userRepository.save(user);

        // TODO: Send Kafka event to Profile and other services that new user is registered

    }
}
