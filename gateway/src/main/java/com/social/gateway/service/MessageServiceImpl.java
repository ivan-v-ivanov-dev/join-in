package com.social.gateway.service;

import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.contract.MessageService;
import com.social.gateway.service.contract.ProfileService;
import com.social.gateway.service.contract.RelationshipService;
import com.social.gateway.service.feign.MessageClient;
import com.social.model.dto.FriendGatewayRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Set;

import static com.social.gateway.service.constants.LoggerConstants.RETRIEVE_USER_ONLINE_FRIENDS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final RelationshipService relationshipService;
    private final MessageClient messageClient;
    private final ImageService imageService;
    private final ProfileService profileService;

    @Override
    public List<FriendGatewayRp> findProfileOnlineFriends(String identity) {
        try {
            Set<String> friendsIdentities = relationshipService.findFriendsByProfileIdentity(identity);
            List<FriendGatewayRp> onlineFriends = friendsIdentities.stream()
                    .filter(messageClient::findUserOnlineStatus)
                    .map(profileIdentity -> FriendGatewayRp.builder()
                            .profileIdentity(profileIdentity)
                            .profileImage(imageService.findProfileImage(profileIdentity))
                            .names(profileService.findProfileNames(profileIdentity))
                            .build())
                    .toList();
            log.info(format(RETRIEVE_USER_ONLINE_FRIENDS_TEMPLATE, identity));
            return onlineFriends;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(feignException.getMessage());
        }
    }
}
