package com.social.relationship.service;

import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.relationship.service.constants.LoggerConstants.*;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfile(String identity) {
        Profile profile = profileRepository.save(Profile.builder().identity(identity).build());
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    public void createFriendship(String senderIdentity, String recipientIdentity) {
        profileRepository.createFriendshipRelationship(senderIdentity, recipientIdentity);
        log.info(String.format(CREATE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE,
                senderIdentity, recipientIdentity));
    }

    @Override
    public void createFriendshipRequest(String senderIdentity, String recipientIdentity) {
        profileRepository.createFriendshipRequestRelationship(senderIdentity, recipientIdentity);
        log.info(String.format(CREATE_FRIEND_RELATIONSHIP_REQUEST_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE,
                senderIdentity, recipientIdentity));
    }
}
