package com.social.post.service;

import com.social.post.model.Comment;
import com.social.post.repository.contract.CommentRepository;
import com.social.post.service.contracts.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
