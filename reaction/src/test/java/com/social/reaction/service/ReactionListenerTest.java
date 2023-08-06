package com.social.reaction.service;

import com.social.kafka.messages.*;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.reaction.service.contracts.CommentService;
import com.social.reaction.service.contracts.PostService;
import com.social.reaction.service.contracts.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ReactionListenerTest {

    @Mock
    ProfileService profileService;
    @Mock
    PostService postService;
    @Mock
    CommentService commentService;
    @InjectMocks
    ReactionListener reactionListener;

    @Test
    public void newUserListener_should_callService() {
        KafkaMessage newUserMessage = NewUserMessage.builder().identity("identity").build();
        reactionListener.newUserListener(newUserMessage);

        verify(profileService, times(1)).save(any());
    }

    @Test
    public void newPostNodeListener_should_callService() {
        KafkaMessage newNodeMessage = createNewNodeMessage();
        reactionListener.newPostNodeListener(newNodeMessage);

        verify(postService, times(1)).save(any());
    }

    @Test
    public void newCommentNodeListener_should_callService() {
        KafkaMessage newNodeMessage = createNewNodeMessage();
        reactionListener.newCommentNodeListener(newNodeMessage);

        verify(commentService, times(1)).save(any());
    }

    @Test
    public void deleteNodesListener_should_callService() {
        KafkaMessage deleteNodesMessage = DeleteNodesMessage.builder()
                .commentsNodesIdentities(Set.of("identity"))
                .postIdentity("postIdentity")
                .build();
        reactionListener.deleteNodesListener(deleteNodesMessage);

        verify(commentService, times(1)).deleteNodes(any());
        verify(postService, times(1)).deleteNode(any());
    }

    @Test
    public void likePostListener_should_callService() {
        KafkaMessage postReactionMessage = createPostReactionMessage();
        reactionListener.likePostListener(postReactionMessage);

        verify(postService, times(1)).likePost(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void dislikePostListener_should_callService() {
        KafkaMessage postReactionMessage = createPostReactionMessage();
        reactionListener.dislikePostListener(postReactionMessage);

        verify(postService, times(1)).dislikePost(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void starPostListener_should_callService() {
        KafkaMessage postReactionMessage = createPostReactionMessage();
        reactionListener.starPostListener(postReactionMessage);

        verify(postService, times(1)).starPost(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void likeCommentListener_should_callService() {
        KafkaMessage commentReactionMessage = createCommentReactionMessage();
        reactionListener.likeCommentListener(commentReactionMessage);

        verify(commentService, times(1)).likeComment(anyString(), anyString(), anyString(), anyString(), anyString());
    }

    @Test
    public void dislikeCommentListener_should_callService() {
        KafkaMessage commentReactionMessage = createCommentReactionMessage();
        reactionListener.dislikeCommentListener(commentReactionMessage);

        verify(commentService, times(1)).dislikeComment(anyString(), anyString(), anyString(), anyString(), anyString());
    }

    private KafkaMessage createNewNodeMessage() {
        return NewNodeMessage.builder().identity("identity").build();
    }

    private KafkaMessage createPostReactionMessage() {
        return PostReactionMessage.builder()
                .reactingUserIdentity("reactingUserIdentity")
                .postIdentity("postIdentity")
                .postAuthorIdentity("postAuthorIdentity")
                .postAuthorNames("postAuthorNames")
                .build();
    }

    private KafkaMessage createCommentReactionMessage() {
        return CommentReactionMessage.builder()
                .reactingUserIdentity("reactingUserIdentity")
                .commentIdentity("commentIdentity")
                .postIdentity("postIdentity")
                .commentAuthorIdentity("commentAuthorIdentity")
                .commentAuthorNames("commentAuthorNames")
                .build();
    }


}
