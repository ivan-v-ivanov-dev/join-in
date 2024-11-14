package com.social.mvc.service;

import com.social.model.dto.NotificationGatewayRp;
import com.social.mvc.service.contract.NotificationService;
import com.social.mvc.service.feign.GatewayClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.mvc.service.constants.ExceptionConstants.GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.mvc.service.constants.LoggerConstants.RETRIEVE_USER_NOTIFICATIONS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final GatewayClient gatewayClient;

    @Override
    public List<NotificationGatewayRp> findProfileNotifications(String identity) {
        try {
            List<NotificationGatewayRp> notifications = gatewayClient.findNotificationsByProfileIdentity(identity);
            log.info(format(RETRIEVE_USER_NOTIFICATIONS_TEMPLATE, identity));
            return notifications;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }
}
