package com.social.notification.service;

import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.NotificationMessage;
import com.social.notification.service.NotificationListener;
import com.social.notification.service.contracts.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificationListenerTest {

    @Mock
    NotificationService notificationService;
    @InjectMocks
    NotificationListener notificationListener;

    @Test
    public void newUserListener_should_callService() {
        NewUserMessage newUserMessage = NewUserMessage.builder().identity("identity").build();
        notificationListener.newUserListener(newUserMessage);

        verify(notificationService, times(1)).createCollection(newUserMessage.getIdentity());
    }

    @Test
    public void newPostNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.newPostNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void newCommentNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.newCommentNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void likePostNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.likePostNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void dislikePostNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.dislikePostNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void starPostNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.starPostNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void likeCommentNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.likeCommentNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    @Test
    public void dislikeCommentNotificationListener_should_callService() {
        NotificationMessage notificationMessage = createNotificationMessage();
        notificationListener.dislikeCommentNotificationListener(notificationMessage);

        verify(notificationService, times(1)).save(any(), anySet());
    }

    private NotificationMessage createNotificationMessage() {
        return NotificationMessage.builder()
                .peopleToNotify(Set.of("test1", "test2"))
                .authorIdentity("authorIdentity")
                .authorNames("authorNames")
                .postIdentity("postIdentity")
                .date(LocalDate.now().toString())
                .build();
    }
}
