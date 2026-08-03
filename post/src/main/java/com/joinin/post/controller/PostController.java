package com.joinin.post.controller;

import com.join_in.common_models.PostRpPostService;
import com.joinin.post.service.contract.CommentService;
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
    private final CommentService commentService;

    /**
     * Reads posts from posts_by_author.
     */
    @GetMapping("/author/{identity}")
    public List<PostRpPostService> retrievePostsByAuthor(@PathVariable String identity) {
        return postService.retrievePostsByAuthor(identity);
    }

    @GetMapping("/author/{identity}/post/identities")
    public List<String> retrievePostIdentitiesByAuthor(@PathVariable String identity) {
        return postService.retrievePostIdentitiesByAuthor(identity);
    }

    @GetMapping("/author/{identity}/comment/identities")
    public List<String> retrieveCommentIdentitiesByAuthor(@PathVariable String identity) {
        return commentService.retrieveCommentIdentitiesByAuthor(identity);
    }

    @GetMapping("/author/{identity}/posts/count")
    public int retrieveAuthorPostsCount(@PathVariable String identity) {
        return postService.retrieveProfilePostsCount(identity);
    }

    @GetMapping("/author/{identity}/comments/count")
    public int retrieveAuthorCommentsCount(@PathVariable String identity) {
        return commentService.retrieveAuthorCommentsCount(identity);
    }
}
