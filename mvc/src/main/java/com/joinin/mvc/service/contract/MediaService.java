package com.joinin.mvc.service.contract;

import java.util.List;

public interface MediaService {
    String retrieveProfileImage(String identity);

    String retrieveProfileBackgroundImage(String identity);

    List<String> retrieveProfileAlbumImages(String identity);
}
