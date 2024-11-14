package com.social.image.service.contract;

import java.util.List;

public interface ImageService {
    String findProfileImage(String identity);

    void createCollection(String identity);

    String findProfileBackgroundImage(String identity);

    List<String> findProfileAlbumImages(String identity);
}
