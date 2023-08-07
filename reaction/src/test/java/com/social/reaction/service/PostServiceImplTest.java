package com.social.reaction.service;

import com.social.reaction.model.Post;
import com.social.reaction.repository.PostRepository;
import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contracts.KafkaMessageSender;
import com.social.reaction.service.feign.PostClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    PostRepository postRepository;
    @Mock
    ProfileRepository profileRepository;
    @Mock
    PostClient postClient;
    @Mock
    KafkaMessageSender kafkaMessageSender;
    @InjectMocks
    PostServiceImpl postService;

    @Test
    public void save_should_callRepository() {
        Post post = Post.builder().identity("identity").build();
        postService.save(post);

        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void deleteNode_should_callRepository() {
        postService.deleteNode(anyString());

        verify(postRepository, times(1)).deleteNodeWithRelations(anyString());
    }

    @Test
    public void likePost_should_deletePreviousUserReactionsToThePost() {
        postService.likePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).deletePossiblePreviousRelations("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void likePost_should_likeAPost() {
        postService.likePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).likePost("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void likePost_should_sendNotifications() {
        when(profileRepository.findPeopleWhoReactedToPost("postIdentity")).thenReturn(Set.of("userIdentity_1"));
        when(postClient.findAllUsersCommentingThePost("postIdentity", "postAuthorIdentity")).thenReturn(Set.of("userIdentity_2"));

        postService.likePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(kafkaMessageSender, times(1)).send(any(), eq(null));
    }

    @Test
    public void dislikePost_should_deletePreviousUserReactionsToThePost() {
        postService.dislikePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).deletePossiblePreviousRelations("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void dislikePost_should_dislikeAPost() {
        postService.dislikePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).dislikePost("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void dislikePost_should_sendNotifications() {
        when(profileRepository.findPeopleWhoReactedToPost("postIdentity")).thenReturn(Set.of("userIdentity_1"));
        when(postClient.findAllUsersCommentingThePost("postIdentity", "postAuthorIdentity")).thenReturn(Set.of("userIdentity_2"));

        postService.dislikePost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(kafkaMessageSender, times(1)).send(any(), eq(null));
    }

    @Test
    public void starPost_should_deletePreviousUserReactionsToThePost() {
        postService.starPost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).deletePossiblePreviousRelations("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void starPost_should_starAPost() {
        postService.starPost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(postRepository, times(1)).starPost("reactingUserIdentity", "postIdentity");
    }

    @Test
    public void starPost_should_sendNotifications() {
        when(profileRepository.findPeopleWhoReactedToPost("postIdentity")).thenReturn(Set.of("userIdentity_1"));
        when(postClient.findAllUsersCommentingThePost("postIdentity", "postAuthorIdentity")).thenReturn(Set.of("userIdentity_2"));

        postService.starPost("reactingUserIdentity", "postIdentity", "postAuthorIdentity", "postAuthorNames");

        verify(kafkaMessageSender, times(1)).send(any(), eq(null));
    }
}
