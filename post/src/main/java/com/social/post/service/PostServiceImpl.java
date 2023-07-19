package com.social.post.service;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.post.service.constants.CollectionTemplateConstant.COLLECTION_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.NEW_USER_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findByPostIdentity(String postIdentity, String authorIdentity) {
        return postRepository.findByPostIdentity(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void save(Post post, String authorIdentity) {
        postRepository.save(post, String.format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(String.format(NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE,
                authorIdentity, post.getPostIdentity()));
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        return postRepository.findAllPostsByAuthorIdentity(String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void delete(String postIdentity, String authorIdentity) {
        postRepository.delete(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void edit(String postIdentity, String newContent, String authorIdentity) {
        postRepository.updateOne(postIdentity, newContent, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public int findAuthorPostsCount(String authorIdentity) {
        return postRepository.findAuthorPostsCount(String.format(COLLECTION_TEMPLATE, authorIdentity));
    }

    @Override
    public void createNewUserCollection(String identity) {
        postRepository.createNewUserCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, identity));
    }
}
