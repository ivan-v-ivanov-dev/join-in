package com.social.reaction.service;

import com.social.reaction.model.Comment;
import com.social.reaction.repository.CommentRepository;
import com.social.reaction.service.contracts.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.reaction.service.constants.LoggerConstants.COMMENT_NODES_DELETED;
import static com.social.reaction.service.constants.LoggerConstants.SAVE_COMMENT_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
        log.info(String.format(SAVE_COMMENT_IN_DATABASE_TEMPLATE, comment.getIdentity()));
    }

    @Override
    public void deleteNodes(Set<String> commentsNodesIdentities) {
        commentsNodesIdentities.forEach(commentRepository::deleteNodeWithRelations);
        log.info(COMMENT_NODES_DELETED);
    }
}
