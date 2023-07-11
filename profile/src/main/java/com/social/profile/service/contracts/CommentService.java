package com.social.profile.service.contracts;

public interface CommentService {
    void comment(String userIdentity, String postIdentity, String comment);
}
