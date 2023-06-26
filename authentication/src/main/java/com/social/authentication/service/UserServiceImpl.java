package com.social.authentication.service;

import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
