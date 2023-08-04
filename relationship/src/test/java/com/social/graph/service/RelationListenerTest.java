package com.social.graph.service;

import com.social.kafka.messages.FriendshipMessage;
import com.social.kafka.messages.NewUserMessage;
import com.social.relationship.service.RelationListener;
import com.social.relationship.service.contracts.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RelationListenerTest {

    @Mock
    ProfileService profileService;

    @InjectMocks
    RelationListener relationListener;

    @Test
    public void listener_should_callService() {
        NewUserMessage newUserMessage = NewUserMessage.builder().identity(anyString()).build();
        relationListener.listener(newUserMessage);

        verify(profileService, times(1)).save(any());
    }

    @Test
    public void acceptFriendshipListener_should_callService() {
        FriendshipMessage friendshipMessage = createFriendshipMessage();
        relationListener.acceptFriendshipListener(friendshipMessage);

        verify(profileService, times(1)).acceptFriendship(any(), any());
    }

    @Test
    public void declineFriendshipListener_should_callService() {
        FriendshipMessage friendshipMessage = createFriendshipMessage();
        relationListener.declineFriendshipListener(friendshipMessage);

        verify(profileService, times(1)).declineFriendship(any(), any());
    }

    @Test
    public void unfriendListener_should_callService() {
        FriendshipMessage friendshipMessage = createFriendshipMessage();
        relationListener.unfriendListener(friendshipMessage);

        verify(profileService, times(1)).unfriend(any(), any());
    }

    private FriendshipMessage createFriendshipMessage() {
        return FriendshipMessage.builder()
                .senderUserIdentity(anyString())
                .recipientUserIdentity(anyString())
                .build();
    }
}
