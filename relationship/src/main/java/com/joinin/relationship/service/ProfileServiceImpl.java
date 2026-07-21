package com.joinin.relationship.service;

import com.joinin.relationship.model.ProfileNode;
import com.joinin.relationship.repository.ProfileRepository;
import com.joinin.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfile(String identity) {
        ProfileNode user = ProfileNode.builder()
                .identity(identity)
                .build();
        ProfileNode savedProfileNode = profileRepository.save(user);
        log.info("User node saved in database. User identity: " + savedProfileNode.getIdentity());
    }
}
