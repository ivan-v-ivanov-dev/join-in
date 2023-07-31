package com.social.reaction.service.contracts;

import com.social.reaction.model.Comment;

import java.util.Set;

public interface CommentService {
    void save(Comment comment);

    void deleteNodes(Set<String> commentsNodesIdentities);

    void likeComment(String reactingUserIdentity, String commentIdentity, String postIdentity,
                     String commentAuthorIdentity, String commentAuthorNames);

    void dislikeComment(String reactingUserIdentity, String commentIdentity, String postIdentity,
                        String commentAuthorIdentity, String commentAuthorNames);
}
