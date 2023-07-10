package com.social.post.controller;

import com.social.post.model.Post;
import com.social.post.service.contracts.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public List<Post> findAllPostsByAuthorIdentity(@RequestParam("authorIdentity") String authorIdentity) {
        return postService.findAllPostsByAuthorIdentity(authorIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Post service is HEALTHY";
    }
}
