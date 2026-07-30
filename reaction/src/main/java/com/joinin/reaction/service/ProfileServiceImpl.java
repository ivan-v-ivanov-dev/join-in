package com.joinin.reaction.service;

import com.joinin.reaction.model.Profile;
import com.joinin.reaction.repository.ProfileRepository;
import com.joinin.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void saveProfile(String identity) {
        Profile profile = Profile.builder()
                .identity(identity)
                .build();
        Profile savedProfileNode = profileRepository.save(profile);
        log.info("Profile node saved in database. Profile identity: " + savedProfileNode.getIdentity());
    }
}
