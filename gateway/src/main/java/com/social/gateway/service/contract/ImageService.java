package com.social.gateway.service.contract;

import java.util.List;

public interface ImageService {
    String findProfileImage(String identity);

    String findProfileBackgroundImage(String identity);

    List<String> findProfileAlbumImages(String identity);
}
