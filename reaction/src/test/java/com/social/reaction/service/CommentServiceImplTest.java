package com.social.reaction.service;

import com.social.reaction.model.Comment;
import com.social.reaction.repository.CommentRepository;
import com.social.reaction.service.contracts.KafkaMessageSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    CommentRepository commentRepository;
    @Mock
    KafkaMessageSender kafkaMessageSender;
    @InjectMocks
    CommentServiceImpl commentService;

    @Test
    public void save_should_callRepository() {
        Comment comment = Comment.builder().identity("identity").build();
        commentService.save(comment);

        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    public void deleteNodes_should_callRepository() {
        Set<String> comments = Set.of("identity_1", "identity_2", "identity_3");
        commentService.deleteNodes(comments);

        verify(commentRepository, times(3)).deleteNodeWithRelations(anyString());
    }

    @Test
    public void likeComment_should_callAllRepositories() {
        commentService.likeComment("reactingUserIdentity", "commentIdentity",
                "postIdentity", "commentAuthorIdentity", "commentAuthorNames");

        verify(commentRepository, times(1)).deletePossiblePreviousRelations(anyString(), anyString());
        verify(commentRepository, times(1)).likeComment(anyString(), anyString());
        verify(kafkaMessageSender, times(1)).send(any(), eq(null));
    }

    @Test
    public void dislikeComment_should_callAllRepositories() {
        commentService.dislikeComment("reactingUserIdentity", "commentIdentity",
                "postIdentity", "commentAuthorIdentity", "commentAuthorNames");

        verify(commentRepository, times(1)).deletePossiblePreviousRelations(anyString(), anyString());
        verify(commentRepository, times(1)).dislikeComment(anyString(), anyString());
        verify(kafkaMessageSender, times(1)).send(any(), eq(null));
    }

}
