package com.social.post.service.contract;

public interface ImageService {
    String findProfileImage(String userIdentity);

    String findProfileBackgroundImage(String userIdentity);
}
