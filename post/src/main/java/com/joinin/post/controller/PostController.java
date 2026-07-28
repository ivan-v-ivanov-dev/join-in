package com.joinin.post.controller;

import com.joinin.post.model.PostResponse;
import com.joinin.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * Reads posts from posts_by_author.
     */
    @GetMapping("/author/{identity}")
    public List<PostResponse> retrievePostsByAuthor(@PathVariable String identity) {
        return postService.retrievePostsByAuthor(identity);
    }
}
