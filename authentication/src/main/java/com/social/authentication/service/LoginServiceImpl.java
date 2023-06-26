package com.social.authentication.service;

import com.social.authentication.model.Log;
import com.social.authentication.model.User;
import com.social.authentication.repository.LogRepository;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.LoginService;
import com.social.authentication.service.feign.ProfileClient;
import com.social.authentication.util.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfileClient profileClient;

    public LoginServiceImpl(LogRepository logRepository,
                            UserRepository userRepository,
                            PasswordEncoder passwordEncoder,
                            ProfileClient profileClient) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.profileClient = profileClient;
    }

    @Override
    public void login(String email, String password) {
        User loggedUser = userRepository.findByEmail(email);

        if (loggedUser != null && passwordEncoder.areEqual(password, loggedUser.getPassword())) {
            Log loggedUserLog = Log.builder().id(UUID.randomUUID().toString()).user(loggedUser).logDate(LocalDate.now()).build();
            logRepository.save(loggedUserLog);
            profileClient.profile(loggedUser.getIdentity());
        }

        throw new IllegalArgumentException();
    }
}
