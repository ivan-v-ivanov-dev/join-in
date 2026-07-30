package com.joinin.reaction.service;

import com.join_in.common_models.CommentReactionsCountRpReactionService;
import com.joinin.reaction.mapper.CommentMapper;
import com.joinin.reaction.model.CommentReactionsCount;
import com.joinin.reaction.repository.CommentRepository;
import com.joinin.reaction.service.contract.CommentService;
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

    @Override
    public List<CommentReactionsCountRpReactionService> retrieveCommentsReactionsCount(List<String> identities) {
        List<CommentReactionsCount> commentReactionsCounts = commentRepository.retrieveCommentReactionsCount(identities);
        log.info("Retrieve reaction counts for all comments. Identities: " + String.join(", ", identities));
        return commentReactionsCounts.stream().map(commentMapper::fromCommentReactionsCounttoCommentReactionsCountRpReactionService).toList();
    }
}
