package com.joinin.reaction.service;

import com.joinin.reaction.model.UserNode;
import com.joinin.reaction.repository.UserNodeRepository;
import com.joinin.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final UserNodeRepository userNodeRepository;

    @Override
    public void saveProfile(String identity) {
        UserNode user = UserNode.builder()
                .identity(identity)
                .build();
        UserNode savedUserNode = userNodeRepository.save(user);
        log.info("User node saved in database. User identity: " + savedUserNode.getIdentity());
    }
}
