package com.social.post.repository.contract;

import com.social.post.model.Comment;

public interface CommentRepository {
    void save(Comment comment);
}
