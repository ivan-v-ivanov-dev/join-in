package com.joinin.media.service.contract;

import java.util.List;

public interface S3MediaService {
    String retrieveProfileImage(String identity);

    String retrieveProfileBackgroundImage(String identity);

    List<String> retrieveProfileAlbumImages(String identity);
}
