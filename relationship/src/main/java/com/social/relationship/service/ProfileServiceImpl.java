package com.social.relationship.service;

import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.relationship.service.constants.LoggerConstants.NEW_USER_SAVED_IN_DATABASE_TEMPLATE;
import static com.social.relationship.service.constants.LoggerConstants.RETRIEVE_FRIENDS_IDENTITIES_FOR_USER_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfile(String identity) {
        Profile profile = profileRepository.save(Profile.builder().identity(identity).build());
        log.info(format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    @Override
    public Set<String> findFriendsByProfileIdentity(String identity) {
        Set<String> identities = profileRepository.findFriendsByProfileIdentity(identity);
        log.info(format(RETRIEVE_FRIENDS_IDENTITIES_FOR_USER_TEMPLATE, identity));
        return identities;
    }

    //    public void createFriendship(String senderIdentity, String recipientIdentity) {
//        profileRepository.createFriendshipRelationship(senderIdentity, recipientIdentity);
//        log.info(String.format(CREATE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE,
//                senderIdentity, recipientIdentity));
//    }
//
//    @Override
//    public void createFriendshipRequest(String senderIdentity, String recipientIdentity) {
//        profileRepository.createFriendshipRequestRelationship(senderIdentity, recipientIdentity);
//        log.info(String.format(CREATE_FRIEND_RELATIONSHIP_REQUEST_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE,
//                senderIdentity, recipientIdentity));
//    }
}
