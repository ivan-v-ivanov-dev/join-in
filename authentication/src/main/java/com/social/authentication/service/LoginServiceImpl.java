package com.social.authentication.service;

import com.social.authentication.model.Log;
import com.social.authentication.model.User;
import com.social.authentication.repository.LogRepository;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.LoginService;
import com.social.authentication.service.contract.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

import static com.social.authentication.service.constants.ExceptionConstants.BAD_CREDENTIALS;
import static com.social.authentication.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(LogRepository logRepository,
                            UserRepository userRepository,
                            PasswordEncoderImpl passwordEncoder) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(String email, String password) {
        User loggedUser = userRepository.findByEmail(email);

        if (loggedUser == null || !passwordEncoder.areEqual(password, loggedUser.getPassword())) {
            log.error(FAILED_TO_AUTHENTICATE_WITH_CREDENTIALS);
            throw new IllegalArgumentException(BAD_CREDENTIALS);
        }

        log.info(String.format(USER_WITH_IDENTITY_LOGGED_TEMPLATE, loggedUser.getIdentity()));

        Log loggedUserLog = Log.builder().id(UUID.randomUUID().toString()).user(loggedUser).logDate(LocalDate.now()).build();
        logRepository.save(loggedUserLog);
        log.info(String.format(USER_WITH_IDENTITY_LOGIN_SAVED_IN_DATABASE_TEMPLATE, loggedUser.getIdentity()));

        return loggedUser.getIdentity();
    }
}
