package com.social.profile.service.contracts;

import java.util.List;

public interface ImageService {
    String findProfileImage(String identity);

    String findProfileBackgroundImage(String identity);

    List<String> findProfileAlbumImage(String identity);
}
