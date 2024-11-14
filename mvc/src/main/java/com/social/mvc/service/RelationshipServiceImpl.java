package com.social.mvc.service;

import com.social.model.dto.FriendGatewayRp;
import com.social.mvc.service.contract.RelationshipService;
import com.social.mvc.service.feign.GatewayClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.mvc.service.constants.LoggerConstants.RETRIEVE_USER_FRIENDS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final GatewayClient gatewayClient;

    @Override
    public List<FriendGatewayRp> findProfileFriends(String identity) {
        List<FriendGatewayRp> friends = gatewayClient.findProfileFriends(identity);
        log.info(format(RETRIEVE_USER_FRIENDS_TEMPLATE, identity));
        return friends;
    }
}
