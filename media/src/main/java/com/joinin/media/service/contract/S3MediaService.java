package com.joinin.media.service.contract;

public interface S3MediaService {
    byte[] getProfileImage(String identity);

    byte[] getProfileBackgroundImage(String identity);
}
