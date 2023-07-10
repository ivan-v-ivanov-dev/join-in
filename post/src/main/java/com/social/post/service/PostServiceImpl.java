package com.social.post.service;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.post.service.constants.LoggerConstants.NEW_POST_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
        log.info(String.format(NEW_POST_SAVED_IN_DATABASE_TEMPLATE, post.getAuthorIdentity(), post.getPostIdentity()));
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        return postRepository.findAllPostsByAuthorIdentity(authorIdentity);
    }
}
