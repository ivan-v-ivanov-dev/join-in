package com.social.post.service;

import com.social.model.dto.PostRp;
import com.social.post.adapter.adapter.ApiGatewayAdapter;
import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

import static com.social.post.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.RETRIEVE_POST_TEMPLATE;
import static com.social.post.service.constants.ServiceConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ApiGatewayAdapter adapter;

    @Override
    public void createCollection(String identity) {
        postRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }

    @Override
    public PostRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity) {
        Post post = postRepository.findByAuthorIdentityAndPostIdentity(postIdentity, format(COLLECTION_TEMPLATE, authorIdentity));
        log.info(format(RETRIEVE_POST_TEMPLATE, post.getPostIdentity()));
        return adapter.fromPostToPostRp(post);
    }
}
