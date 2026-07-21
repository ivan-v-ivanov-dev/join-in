package com.joinin.message.service;

import com.joinin.message.repository.ProfileRepository;
import com.joinin.message.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfileOffline(String identity) {
       String offlineUser = profileRepository.saveOffline(identity);
       log.info("User saved in Redis. User identity: " + identity + ". Status: " + offlineUser);
    }
}
