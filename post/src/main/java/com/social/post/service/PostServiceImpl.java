package com.social.post.service;

import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.post.service.constants.LoggerConstants.COLLECTION_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createCollection(String identity) {
        postRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }
}
