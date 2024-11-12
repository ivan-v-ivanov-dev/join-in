package com.social.post.controller;

import com.social.post.model.Post;
import com.social.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/author/{authorIdentity}/post/{postIdentity}")
    public Post findByPostIdentity(@PathVariable("authorIdentity") String authorIdentity,
                                   @PathVariable("postIdentity") String postIdentity) {
        return postService.findByAuthorIdentityAndPostIdentity(authorIdentity, postIdentity);
    }
    @GetMapping("/health")
    public String health() {
        return "Post service is HEALTHY";
    }
}
