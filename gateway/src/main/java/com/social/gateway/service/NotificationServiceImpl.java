package com.social.gateway.service;

import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.contract.NotificationService;
import com.social.gateway.service.feign.NotificationClient;
import com.social.model.dto.NotificationGatewayRp;
import com.social.model.dto.NotificationRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.gateway.service.constants.LoggerConstants.RETRIEVE_USER_NOTIFICATIONS_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private NotificationClient notificationClient;
    private final ImageService imageService;

    @Override
    public List<NotificationGatewayRp> findNotificationsByProfileIdentity(String identity) {
        try {
            List<NotificationRp> notificationsRp = notificationClient.findProfileNotifications(identity);
            List<NotificationGatewayRp> notificationGatewayRps = notificationsRp.stream()
                    .map(notification -> NotificationGatewayRp.builder()
                            .authorProfileImage(imageService.findProfileImage(notification.getAuthorIdentity()))
                            .postIdentity(notification.getPostIdentity())
                            .notification(notification.getNotification())
                            .postedAgo(notification.getPostedAgo()).build())
                    .toList();
            log.info(format(RETRIEVE_USER_NOTIFICATIONS_TEMPLATE, identity));
            return notificationGatewayRps;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }
}
