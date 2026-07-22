package com.joinin.media.service.contract;

import java.util.List;

public interface S3MediaService {
    byte[] getProfileImage(String identity);

    byte[] getProfileBackgroundImage(String identity);

    List<String> getProfileAlbumImages(String identity);
}
