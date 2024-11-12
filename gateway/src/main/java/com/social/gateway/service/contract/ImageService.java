package com.social.gateway.service.contract;

import java.util.List;
import java.util.Map;

public interface ImageService {
    String findProfileImage(String identity);

    String findProfileBackgroundImage(String identity);

    Map<String, List<String>> findProfileAlbumImages(String identity);
}
