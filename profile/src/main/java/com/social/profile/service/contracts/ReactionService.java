package com.social.profile.service.contracts;

public interface ReactionService {
    void likePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity);

    void dislikePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity);

    void starPost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity);

    void likeComment(String reactingUserIdentity, String commentIdentity, String postIdentity, String commentAuthorIdentity);

    void dislikeComment(String reactingUserIdentity, String commentIdentity, String postIdentity, String commentAuthorIdentity);
}
