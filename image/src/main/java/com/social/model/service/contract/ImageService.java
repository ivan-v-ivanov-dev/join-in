package com.social.model.service.contract;

import java.util.List;
import java.util.Map;

public interface ImageService {
    String findProfileImage(String identity);

    void createCollection(String identity);

    String findProfileBackgroundImage(String identity);

    Map<String, List<String>> findProfileAlbumImages(String identity);
}
