package com.social.post.service;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.post.service.constants.LoggerConstants.NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findByPostIdentity(String postIdentity) {
        return postRepository.findByPostIdentity(postIdentity);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
        log.info(String.format(NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE,
                post.getAuthorIdentity(), post.getPostIdentity()));
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        return postRepository.findAllPostsByAuthorIdentity(authorIdentity);
    }

    @Override
    public void delete(String postIdentity) {
        postRepository.delete(postIdentity);
    }

    @Override
    public void edit(String postIdentity, String newContent) {
        postRepository.updateOne(postIdentity, newContent);
    }
}
