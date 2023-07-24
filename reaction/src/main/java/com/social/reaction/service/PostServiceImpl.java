package com.social.reaction.service;

import com.social.reaction.model.Post;
import com.social.reaction.repository.PostRepository;
import com.social.reaction.service.contracts.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
