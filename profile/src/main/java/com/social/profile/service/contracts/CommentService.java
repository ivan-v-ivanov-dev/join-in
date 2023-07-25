package com.social.profile.service.contracts;

public interface CommentService {
    void comment(String commentAuthorIdentity, String postIdentity, String postAuthorIdentity, String comment);
}
