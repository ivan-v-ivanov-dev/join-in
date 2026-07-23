package com.joinin.gateway.service.contract;

import java.util.List;

public interface MediaService {
    byte[] getProfileImage(String identity);

    byte[] getProfileBackgroundImage(String identity);

    List<String> getProfileAlbumImages(String identity);
}
