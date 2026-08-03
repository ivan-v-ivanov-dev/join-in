package com.joinin.post.service.contract;

import java.util.List;

public interface CommentService {
    int retrieveAuthorCommentsCount(String identity);

    List<String> retrieveCommentIdentitiesByAuthor(String identity);
}
