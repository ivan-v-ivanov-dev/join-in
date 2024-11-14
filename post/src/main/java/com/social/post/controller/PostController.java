package com.social.post.controller;

import com.social.model.dto.PostRp;
import com.social.post.model.Post;
import com.social.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/author/{authorIdentity}/post/{postIdentity}")
    public ResponseEntity<PostRp> findByAuthorIdentityAndPostIdentity(@PathVariable("authorIdentity") String authorIdentity,
                                                     @PathVariable("postIdentity") String postIdentity) {
        return ResponseEntity.ok(postService.findByAuthorIdentityAndPostIdentity(authorIdentity, postIdentity));
    }

    @GetMapping("/author/{authorIdentity}/posts")
    public ResponseEntity<List<PostRp>> findPostsByAuthorIdentity(@PathVariable("authorIdentity") String authorIdentity) {
        return ResponseEntity.ok(postService.findPostsByAuthorIdentity(authorIdentity));
    }

    @GetMapping("/author/{authorIdentity}/posts/count")
    public int findAuthorPostsCount(@PathVariable("authorIdentity") String authorIdentity) {
        return postService.findAuthorPostsCount(authorIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Post service is HEALTHY";
    }
}
