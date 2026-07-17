package com.joinin.profile.service;

import com.joinin.profile.models.User;
import com.joinin.profile.repository.UserRepository;
import com.joinin.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        User savedUser = userRepository.save(user);
        log.info("User saved in database. User identity: " + savedUser.getIdentity());
    }
}
