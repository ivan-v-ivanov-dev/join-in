package com.joinin.reaction.service;

import com.join_in.common_models.PostReactionsCountRpReactionService;
import com.joinin.reaction.mapper.PostMapper;
import com.joinin.reaction.model.PostReactionsCount;
import com.joinin.reaction.repository.PostRepository;
import com.joinin.reaction.service.contract.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    public List<PostReactionsCountRpReactionService> retrievePostReactionsCount(List<String> identities) {
        List<PostReactionsCount> postReactionsCounts = postRepository.retrievePostReactionsCount(identities);
        log.info("Retrieve reaction counts for all posts. Identities: " + String.join(", ", identities));
        return postReactionsCounts.stream().map(postMapper::fromPostReactionsCounttoPostReactionsCountRpReactionService).toList();
    }
}
