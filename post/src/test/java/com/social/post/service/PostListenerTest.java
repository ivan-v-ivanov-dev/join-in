package com.social.post.service;

import com.social.kafka.messages.*;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.service.contracts.IdentityGenerator;
import com.social.post.service.contracts.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostListenerTest {

    @Mock
    IdentityGenerator identityGenerator;
    @Mock
    PostService postService;
    @InjectMocks
    PostListener postListener;

    @Test
    public void postPublicationListener_shouldCallSaveComment() {
        PostMessage postMessage = PostMessage.builder()
                .userIdentity("userIdentity")
                .userNames("userNames")
                .content("content")
                .postDate(LocalDate.now().toString())
                .build();

        when(identityGenerator.generate(postMessage.getUserIdentity(), postMessage.getContent(), postMessage.getPostDate()))
                .thenReturn("identityGenerator");

        postListener.postPublicationListener(postMessage);

        verify(postService, times(1)).save(any(Post.class), eq(postMessage.getUserIdentity()), eq(postMessage.getUserNames()));
    }

    @Test
    public void postCommentListener_shouldCallSave() {
        CommentMessage commentMessage = CommentMessage.builder()
                .postIdentity("postIdentity")
                .postAuthorIdentity("postAuthorIdentity")
                .commentAuthorIdentity("commentAuthorIdentity")
                .commentAuthorNames("commentAuthorNames")
                .content("content")
                .postDate(LocalDate.now().toString())
                .build();

        when(identityGenerator.generate(commentMessage.getCommentAuthorIdentity(), commentMessage.getContent(), commentMessage.getPostDate()))
                .thenReturn("identityGenerator");

        postListener.postCommentListener(commentMessage);

        verify(postService, times(1)).saveComment(any(Comment.class), eq(commentMessage.getPostIdentity()),
                eq(commentMessage.getPostAuthorIdentity()), eq(commentMessage.getCommentAuthorNames()));
    }

    @Test
    public void deletePostListener_shouldCallDeletePost() {
        DeletePostMessage deletePostMessage = DeletePostMessage.builder()
                .postIdentity("postIdentity")
                .authorIdentity("authorIdentity")
                .build();

        postListener.deletePostListener(deletePostMessage);

        verify(postService, times(1)).delete(deletePostMessage.getPostIdentity(), deletePostMessage.getAuthorIdentity());
    }

    @Test
    public void editPostListener_shouldCallEditPost() {
        EditPostMessage editPostMessage = EditPostMessage.builder()
                .postIdentity("postIdentity")
                .auhthorIdentity("auhthorIdentity")
                .newContent("newContent")
                .build();

        postListener.editPostListener(editPostMessage);

        verify(postService, times(1)).edit(editPostMessage.getPostIdentity(), editPostMessage.getNewContent(), editPostMessage.getAuhthorIdentity());
    }

    @Test
    public void listener_shouldCallCreateNewCollection() {
        NewUserMessage newUserMessage = NewUserMessage.builder()
                .identity("identity")
                .build();

        postListener.listener(newUserMessage);

        verify(postService, times(1)).createNewUserCollection(newUserMessage.getIdentity());
    }

}
