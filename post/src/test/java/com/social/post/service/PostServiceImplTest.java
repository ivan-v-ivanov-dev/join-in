package com.social.post.service;

import com.social.kafka.messages.DeleteNodesMessage;
import com.social.kafka.messages.NewNodeMessage;
import com.social.kafka.messages.NotificationMessage;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.repository.contract.ProfileRepository;
import com.social.post.service.contracts.KafkaMessageSender;
import com.social.post.service.feign.ImageClient;
import com.social.post.service.feign.ReactionClient;
import com.social.post.service.feign.RelationshipClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    PostRepository postRepository;
    @Mock
    ProfileRepository profileRepository;
    @Mock
    RelationshipClient relationshipClient;
    @Mock
    ReactionClient reactionClient;
    @Mock
    ImageClient imageClient;
    @Mock
    KafkaMessageSender kafkaMessageSender;
    @InjectMocks
    PostServiceImpl postService;

    @Test
    public void findByPostIdentity_should_findPost() {
        Comment comment = createComment();
        Post post = createPost(comment);
        when(postRepository.findByPostIdentity(anyString(), anyString())).thenReturn(post);
        when(imageClient.findProfileImage(anyString())).thenReturn("image");

        assertEquals(post, postService.findByPostIdentity(anyString(), anyString()));
    }

    @Test
    public void findByPostIdentity_should_throwException() {
        Comment comment = createComment();
        Post post = createPost(comment);
        when(postRepository.findByPostIdentity(anyString(), anyString())).thenReturn(post);
        when(imageClient.findProfileImage(anyString())).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> postService.findByPostIdentity(anyString(), anyString()));
    }

    @Test
    public void save_should_savePost() {
        when(relationshipClient.findFriendsIdentities(anyString())).thenReturn(Set.of("identity"));

        Post post = createPost(createComment());
        String authorIdentity = "authorIdentity";
        String authorNames = "authorNames";
        postService.save(post, authorIdentity, authorNames);

        verify(postRepository, times(1)).save(post, String.format("c_%s", authorIdentity));
    }

    @Test
    public void save_should_sendNotifications() {
        when(relationshipClient.findFriendsIdentities(anyString())).thenReturn(Set.of("identity"));

        Post post = createPost(createComment());
        String authorIdentity = "authorIdentity";
        String authorNames = "authorNames";
        postService.save(post, authorIdentity, authorNames);

        verify(kafkaMessageSender, times(1)).send(any(NotificationMessage.class), eq(null));
    }

    @Test
    public void save_should_sendNewNodeMessage() {
        when(relationshipClient.findFriendsIdentities(anyString())).thenThrow(FeignException.class);

        Post post = createPost(createComment());
        String authorIdentity = "authorIdentity";
        String authorNames = "authorNames";
        postService.save(post, authorIdentity, authorNames);

        verify(kafkaMessageSender, times(1)).send(any(NewNodeMessage.class), eq(null));
    }

    @Test
    public void findAllPostsByAuthorIdentity_should_FindPosts() {
        List<Post> expected = List.of(createPost(createComment()));
        when(postRepository.findAllPostsByAuthorIdentity(String.format("c_%s", "authorIdentity"))).thenReturn(expected);
        when(imageClient.findProfileImage(anyString())).thenReturn("image");
        when(reactionClient.findLikesAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoLikedThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findDislikesAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoDislikedThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findStarsAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoStaredThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findLikesACommentProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findDislikesACommentProfileCount(anyString())).thenReturn(1);

        List<Post> result = postService.findAllPostsByAuthorIdentity("authorIdentity");

        assertEquals(expected, result);
    }

    @Test
    public void findAllPostsByAuthorIdentity_should_throw() {
        when(postRepository.findAllPostsByAuthorIdentity(String.format("c_%s", "authorIdentity")))
                .thenReturn(List.of(createPost(createComment())));
        when(imageClient.findProfileImage(anyString())).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> postService.findAllPostsByAuthorIdentity("authorIdentity"));
    }

    @Test
    public void delete_should_deletePost() {
        postService.delete("postIdentity", "authorIdentity");

        verify(postRepository, times(1)).delete("postIdentity", String.format("c_%s", "authorIdentity"));
    }

    @Test
    public void delete_should_sendNotifications() {
        when(postRepository.findAllCommentIdentitiesForAPost("postIdentity", String.format("c_%s", "authorIdentity")))
                .thenReturn(Set.of("identity"));

        postService.delete("postIdentity", "authorIdentity");

        verify(kafkaMessageSender, times(1)).send(any(DeleteNodesMessage.class), eq(null));
    }

    @Test
    public void edit_should_editPost() {
        postService.edit("postIdentity", "newContent", "authorIdentity");

        verify(postRepository, times(1)).updateOne("postIdentity", "newContent", String.format("c_%s", "authorIdentity"));
    }

    @Test
    public void findAuthorPostsCount_should_returnCount() {
        when(postRepository.findAuthorPostsCount(String.format("c_%s", "authorIdentity"))).thenReturn(1);

        assertEquals(1, postService.findAuthorPostsCount("authorIdentity"));
    }

    @Test
    public void createNewUserCollection_should_callRepository() {
        postService.createNewUserCollection("identity");

        verify(postRepository, times(1)).createNewUserCollection(String.format("c_%s", "identity"));
    }

    @Test
    public void saveComment_should_callSaveComment() {
        Comment comment = createComment();
        postService.saveComment(comment, "postIdentity", "postAuthorIdentity", "authorNames");

        verify(postRepository, times(1)).saveComment(comment, "postIdentity", String.format("c_%s", "postAuthorIdentity"));
    }

    @Test
    public void saveComment_should_sendNewNodeMessages() {
        Comment comment = createComment();
        postService.saveComment(comment, "postIdentity", "postAuthorIdentity", "authorNames");

        verify(kafkaMessageSender, times(1)).send(any(NewNodeMessage.class), eq(null));
    }

    @Test
    public void saveComment_should_sendNotifications() {
        Set<String> usersCommentingThePost = new HashSet<>();
        usersCommentingThePost.add("identity_1");
        when(profileRepository.findAllUsersCommentingThePost("postIdentity", String.format("c_%s", "postAuthorIdentity")))
                .thenReturn(usersCommentingThePost);
        when(reactionClient.findPeopleWhoReactedToPost(anyString())).thenReturn(Set.of("identity_2"));

        Comment comment = createComment();
        postService.saveComment(comment, "postIdentity", "postAuthorIdentity", "authorNames");

        verify(kafkaMessageSender, times(1)).send(any(NotificationMessage.class), eq(null));
    }

    @Test
    public void findFeedPosts_should_findPosts() {
        Post post = createPost(createComment());
        Set<String> friendIdentities = new HashSet<>();
        friendIdentities.add("userIdentity_2");
        when(relationshipClient.findFriendsIdentities("userIdentity")).thenReturn(friendIdentities);
        when(postRepository.findAllPostsByAuthorIdentity(anyString())).thenReturn(List.of(post));
        when(imageClient.findProfileImage(anyString())).thenReturn("image");
        when(reactionClient.findLikesAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoLikedThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findDislikesAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoDislikedThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findStarsAPostProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findPeopleWhoStaredThePost(anyString())).thenReturn(Set.of("identity"));
        when(reactionClient.findLikesACommentProfileCount(anyString())).thenReturn(1);
        when(reactionClient.findDislikesACommentProfileCount(anyString())).thenReturn(1);

        assertEquals(post, postService.findFeedPosts("userIdentity").get(0));
    }

    @Test
    public void findFeedPosts_should_throw() {
        when(relationshipClient.findFriendsIdentities("userIdentity")).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> postService.findFeedPosts("userIdentity"));
    }

    private Post createPost(Comment comment) {
        return Post.builder()
                .id("id")
                .postIdentity("postIdentity")
                .authorIdentity("authorIdentity")
                .content("content")
                .comments(List.of(comment))
                .postDate(LocalDate.now())
                .build();
    }

    private Comment createComment() {
        return Comment.builder()
                .id("id")
                .commentIdentity("commentIdentity")
                .authorIdentity("authorIdentity")
                .content("content")
                .postDate(LocalDate.now())
                .build();
    }
}
