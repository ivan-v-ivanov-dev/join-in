package com.social.post.repository.contract;

public interface ImageRepository {
    String findProfileImage(String collection);

    String findProfileBackgroundImage(String collection);
}
