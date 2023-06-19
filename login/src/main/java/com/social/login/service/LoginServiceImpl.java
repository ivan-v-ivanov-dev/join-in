package com.social.login.service;

import com.social.login.model.Log;
import com.social.login.model.User;
import com.social.login.repository.LogRepository;
import com.social.login.repository.UserRepository;
import com.social.login.service.contract.LoginService;
import com.social.login.service.feign.ProfileClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final ProfileClient profileClient;

    public LoginServiceImpl(LogRepository logRepository,
                            UserRepository userRepository,
                            ProfileClient profileClient) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.profileClient = profileClient;
    }

    @Override
    public void login() {
        User loggedUser = findLoggedUser();
        Log loggedUserLog = Log.builder().id(UUID.randomUUID().toString()).user(loggedUser).logDate(LocalDate.now()).build();
        logRepository.save(loggedUserLog);
        profileClient.profile(loggedUser.getIdentity());
    }

    private User findLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String email = userDetails.getUsername();
            return userRepository.findByEmail(email);
        }
        return null;
    }
}