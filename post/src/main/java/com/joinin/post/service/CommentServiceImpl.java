package com.joinin.post.service;

import com.joinin.post.model.CommentByAuthorEntity;
import com.joinin.post.repository.CommentByAuthorRepository;
import com.joinin.post.service.contract.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentByAuthorRepository commentByAuthorRepository;

    @Override
    public int retrieveAuthorCommentsCount(String identity) {
        int commentsCount = commentByAuthorRepository.countAuthorComments(identity);
        log.info("Retrieve comments count for profile: " + identity);
        return commentsCount;
    }

    @Override
    public List<String> retrieveCommentIdentitiesByAuthor(String identity) {
        List<CommentByAuthorEntity> commentByAuthorEntities = commentByAuthorRepository.retrieveCommentsByAuthor(identity);
        log.info("Retrieve comments count for profile: " + identity);
        return commentByAuthorEntities
                .stream()
                .map(e -> e.getKey().getCommentIdentity())
                .toList();
    }
}
