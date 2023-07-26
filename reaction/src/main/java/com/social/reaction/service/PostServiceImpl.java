package com.social.reaction.service;

import com.social.reaction.model.Post;
import com.social.reaction.repository.PostRepository;
import com.social.reaction.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.reaction.service.constants.LoggerConstants.*;

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
        log.info(String.format(SAVE_POST_IN_DATABASE_TEMPLATE, post.getIdentity()));
    }

    @Override
    public void deleteNode(String postIdentity) {
        postRepository.deleteNodeWithRelations(postIdentity);
        log.info(POST_NODE_DELETED);
    }

    @Override
    public void likePost(String userIdentity, String postIdentity) {
        postRepository.deletePossiblePreviousRelations(userIdentity, postIdentity);
        log.info(String.format(DELETE_PREVIOUS_POSSIBLE_REACTIONS_TEMPLATE, userIdentity, postIdentity));

        postRepository.likePost(userIdentity, postIdentity);
        log.info(String.format(POST_LIKED_BY_USER_TEMPLATE, userIdentity, postIdentity));
    }
}
