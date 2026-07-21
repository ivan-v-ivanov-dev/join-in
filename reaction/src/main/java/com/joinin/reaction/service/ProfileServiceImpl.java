package com.joinin.reaction.service;

import com.joinin.reaction.model.ProfileNode;
import com.joinin.reaction.repository.ProfileNodeRepository;
import com.joinin.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileNodeRepository profileNodeRepository;

    @Override
    public void saveProfile(String identity) {
        ProfileNode user = ProfileNode.builder()
                .identity(identity)
                .build();
        ProfileNode savedProfileNode = profileNodeRepository.save(user);
        log.info("User node saved in database. User identity: " + savedProfileNode.getIdentity());
    }
}
