package com.social.gateway.service.contract;

public interface ImageService {
    String findProfileImage(String identity);

    String findProfileBackgroundImage(String identity);
}
