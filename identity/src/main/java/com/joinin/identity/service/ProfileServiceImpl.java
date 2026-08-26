package com.joinin.identity.service;

import com.joinin.identity.repository.ProfileRepository;
import com.joinin.identity.service.contract.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void updateProfilePassword(String identity, String password) {
        profileRepository.updatePassword(identity, passwordEncoder.encode(password));
        log.info("Update profile password. Profile identity: " + identity);
    }
}
