package com.social.authentication.service;

import com.social.authentication.model.Log;
import com.social.authentication.model.User;
import com.social.authentication.repository.LogRepository;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.LoginService;
import com.social.authentication.service.feign.ProfileClient;
import com.social.authentication.util.PasswordEncoderImpl;
import com.social.authentication.util.contracts.PasswordEncoder;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.time.LocalDate;
import java.util.UUID;

import static com.social.authentication.service.constants.ExceptionConstants.BAD_CREDENTIALS;
import static com.social.authentication.service.constants.ExceptionConstants.PROFILE_PAGE_CAN_NOT_BE_LOADED;
import static com.social.authentication.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfileClient profileClient;

    public LoginServiceImpl(LogRepository logRepository,
                            UserRepository userRepository,
                            PasswordEncoderImpl passwordEncoder,
                            ProfileClient profileClient) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.profileClient = profileClient;
    }

    @Override
    public void login(String email, String password) throws ConnectException {
        User loggedUser = userRepository.findByEmail(email);

        if (loggedUser != null && passwordEncoder.areEqual(password, loggedUser.getPassword())) {
            log.info(String.format(USER_LOGGED_TEMPLATE, email));

            Log loggedUserLog = Log.builder().id(UUID.randomUUID().toString()).user(loggedUser).logDate(LocalDate.now()).build();
            logRepository.save(loggedUserLog);
            log.info(String.format(USER_LOGIN_SAVED_IN_DATABASE_TEMPLATE, email));

            log.info(REDIRECTING_TO_PROFILE_SERVICE);
            try {
                profileClient.profile(loggedUser.getIdentity());
            } catch (RetryableException retryableException) {
                log.error(String.format(CAN_NOT_REDIRECT_TO_PROFILE_SERVICE_TEMPLATE, retryableException.getMessage()));
                throw new ConnectException(PROFILE_PAGE_CAN_NOT_BE_LOADED);
            }
        }

        log.error(FAILED_TO_AUTHENTICATE_WITH_CREDENTIALS);
        throw new IllegalArgumentException(BAD_CREDENTIALS);
    }
}
