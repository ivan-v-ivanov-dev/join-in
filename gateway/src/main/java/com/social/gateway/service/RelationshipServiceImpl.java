package com.social.gateway.service;

import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.contract.ProfileService;
import com.social.gateway.service.contract.RelationshipService;
import com.social.gateway.service.feign.RelationshipClient;
import com.social.model.dto.FriendGatewayRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Set;

import static com.social.gateway.service.constants.LoggerConstants.RETRIEVE_USER_FRIENDS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipClient relationshipClient;
    private final ImageService imageService;
    private final ProfileService profileService;

    @Override
    public List<FriendGatewayRp> findProfileFriends(String identity) {
        try {
            Set<String> identities = relationshipClient.findFriendsByProfileIdentity(identity);
            List<FriendGatewayRp> friends = identities.stream().map(profileIdentity ->
                            FriendGatewayRp.builder()
                                    .profileIdentity(profileIdentity)
                                    .profileImage(imageService.findProfileImage(profileIdentity))
                                    .names(profileService.findProfileNames(profileIdentity))
                                    .build())
                    .toList();
            log.info(format(RETRIEVE_USER_FRIENDS_TEMPLATE, identity));
            return friends;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }
}
