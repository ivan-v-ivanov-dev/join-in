package com.joinin.post.service;

import com.joinin.post.repository.CommentByAuthorRepository;
import com.joinin.post.service.contract.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
