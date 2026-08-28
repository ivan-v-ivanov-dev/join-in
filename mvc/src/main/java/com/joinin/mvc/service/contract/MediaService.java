package com.joinin.mvc.service.contract;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {
    String retrieveProfileImage(String identity);

    String retrieveProfileBackgroundImage(String identity);

    List<String> retrieveProfileAlbumImages(String identity);

    void updateProfileImage(String identity, MultipartFile profileImage);

    void updateBackgroundImage(String identity, MultipartFile backgroundImage);
}
