package com.joinin.gateway.service.contract;

import java.util.List;

public interface MediaService {
    String retrieveProfileImage(String identity);

    String retrieveProfileBackgroundImage(String identity);

    List<String> getProfileAlbumImages(String identity);
}
