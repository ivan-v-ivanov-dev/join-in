package com.joinin.reaction.service;

import com.join_in.common_models.CommentReactionsCountRpReactionService;
import com.joinin.reaction.mapper.CommentMapper;
import com.joinin.reaction.model.CommentReactionsCount;
import com.joinin.reaction.repository.CommentRepository;
import com.joinin.reaction.service.contract.CommentService;
import com.joinin.reaction.service.feign.PostServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostServiceClient postServiceClient;

    @Override
    public List<CommentReactionsCountRpReactionService> retrieveCommentsReactionsCount(List<String> identities) {
        List<CommentReactionsCount> commentReactionsCounts = commentRepository.retrieveCommentReactionsCount(identities);
        log.info("Retrieve reaction counts for all comments. Identities: " + String.join(", ", identities));
        return commentReactionsCounts.stream().map(commentMapper::fromCommentReactionsCounttoCommentReactionsCountRpReactionService).toList();
    }

    @Override
    public int retrieveCommentsReactionsCountByProfileIdentity(String identity) {
        List<String> commentIdentities = postServiceClient.retrieveCommentIdentitiesByAuthor(identity);
        log.info("Retrieve comment identities for profile: " + identity);
        int commentsReactionsCount = commentRepository.retrieveCommentsReactionsCount(commentIdentities);
        log.info("Retrieve all comments reactions count for comments: " + String.join(", ", commentIdentities));
        return commentsReactionsCount;
    }
}
