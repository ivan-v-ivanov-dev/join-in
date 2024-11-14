package com.social.mvc.service;

import com.social.model.dto.FriendGatewayRp;
import com.social.mvc.service.contract.MessageService;
import com.social.mvc.service.feign.GatewayClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.mvc.service.constants.LoggerConstants.RETRIEVE_USER_ONLINE_FRIENDS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final GatewayClient gatewayClient;

    @Override
    public List<FriendGatewayRp> findProfileOnlineFriends(String identity) {
        try {
            List<FriendGatewayRp> onlineFriends = gatewayClient.findProfileOnlineFriends(identity);
            log.info(format(RETRIEVE_USER_ONLINE_FRIENDS_TEMPLATE, identity));
            return onlineFriends;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(feignException.getMessage());
        }
    }
}
