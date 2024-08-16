package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.PasswordEncoder;
import com.social.authentication.service.contract.RegisterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.social.authentication.service.constants.ExceptionConstants.USER_ALREADY_EXISTS;
import static com.social.authentication.service.constants.ExceptionConstants.USER_ALREADY_EXISTS_WITH_EMAIL_TEMPLATE;
import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE;
import static java.lang.String.format;

@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(String identity, String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            log.warn(format(USER_ALREADY_EXISTS_WITH_EMAIL_TEMPLATE, email));
            throw new IllegalArgumentException(USER_ALREADY_EXISTS);
        }

        User savedUser = userRepository.save(User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .identity(identity).build());
        log.info(format(NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE, savedUser.getIdentity()));
    }
}
