package com.joinin.media.service;

import com.joinin.media.model.Post;
import com.joinin.media.repository.PostRepository;
import com.joinin.media.service.contract.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post retrieveByIdentity(String identity) {
        Post post = postRepository.retrieveByIdentity(identity);
        log.info("Retrieve post by identity from database: " + post.getIdentity());
        return post;
    }

    @Override
    public void savePost(String postIdentity, String imageUrl) {
        Post post = Post.builder().identity(postIdentity).imageUrl(imageUrl).build();
        postRepository.save(post);
        log.info("Post image saved in database. Post identity: " + postIdentity);
    }
}
