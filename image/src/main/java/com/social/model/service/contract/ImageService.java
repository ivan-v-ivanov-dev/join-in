package com.social.model.service.contract;

public interface ImageService {
    String findProfileImage(String identity);

    void createCollection(String identity);
}
