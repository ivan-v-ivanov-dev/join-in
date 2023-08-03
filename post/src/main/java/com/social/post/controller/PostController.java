package com.social.post.controller;

import com.social.post.model.Post;
import com.social.post.service.contracts.PostService;
import com.social.post.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PostController {

    private final PostService postService;
    private final ProfileService profileService;

    public PostController(PostService postService,
                          ProfileService profileService) {
        this.postService = postService;
        this.profileService = profileService;
    }

    @PostMapping("/post")
    public Post findByPostIdentity(@RequestParam("postIdentity") String postIdentity,
                                   @RequestParam("authorIdentity") String authorIdentity) {
        return postService.findByPostIdentity(postIdentity, authorIdentity);
    }

    @PostMapping("/post/comments/authors")
    public Set<String> findAllUsersCommentingThePost(@RequestParam("postIdentity") String postIdentity,
                                                     @RequestParam("authorIdentity") String authorIdentity) {
        return profileService.findAllUsersCommentingThePost(postIdentity, authorIdentity);
    }

    @PostMapping("/author/posts")
    public List<Post> findAllPostsByAuthorIdentity(@RequestParam("authorIdentity") String authorIdentity) {
        return postService.findAllPostsByAuthorIdentity(authorIdentity);
    }

    @PostMapping("/author/posts/count")
    public int findAuthorPostsCount(@RequestParam("authorIdentity") String authorIdentity) {
        return postService.findAuthorPostsCount(authorIdentity);
    }

    @PostMapping("/feed/posts")
    public List<Post> findFeedPosts(@RequestParam("userIdentity") String userIdentity) {
        return postService.findFeedPosts(userIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Post service is HEALTHY";
    }
}
