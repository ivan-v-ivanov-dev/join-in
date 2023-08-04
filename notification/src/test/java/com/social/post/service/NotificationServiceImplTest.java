package com.social.post.service;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.NotificationServiceImpl;
import com.social.notification.service.feign.ImageClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceImplTest {

    @Mock
    NotificationRepository notificationRepository;
    @Mock
    ImageClient imageClient;
    @InjectMocks
    NotificationServiceImpl notificationService;

    @Test
    public void createCollection_should_callRepository() {
        notificationService.createCollection(anyString());
        verify(notificationRepository, times(1)).createCollection(anyString());
    }

    @Test
    public void save_should_callRepository() {
        Notification notification = createNotification();
        notificationService.save(notification, Set.of("userToNotify"));
        verify(notificationRepository, times(1)).save(notification, "c_userToNotify");
    }

    @Test
    public void findUserNotifications_should_returnListWithNotifications() {
        String userIdentity = "userIdentity";
        List<Notification> expected = createListWithNotifications();

        when(notificationRepository.findUserNotifications("c_userIdentity")).thenReturn(expected);
        when(imageClient.findProfileImage("authorIdentity")).thenReturn("image");

        assertEquals(expected, notificationService.findUserNotifications(userIdentity));
    }

    @Test
    public void findUserNotifications_should_throwException() {
        String userIdentity = "userIdentity";
        List<Notification> expected = createListWithNotifications();

        when(notificationRepository.findUserNotifications("c_userIdentity")).thenReturn(expected);
        when(imageClient.findProfileImage("authorIdentity")).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> notificationService.findUserNotifications(userIdentity));
    }

    private List<Notification> createListWithNotifications() {
        return List.of(createNotification());
    }

    private Notification createNotification() {
        return Notification.builder()
                .authorIdentity("authorIdentity")
                .date(LocalDate.now())
                .build();
    }
}
