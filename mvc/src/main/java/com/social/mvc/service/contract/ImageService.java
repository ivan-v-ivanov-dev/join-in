package com.social.mvc.service.contract;

import java.util.List;
import java.util.Map;

public interface ImageService {
    String findProfileImage(String identity);

    String findBackgroundImage(String identity);

    Map<String, List<String>> findAlbums(String identity);
}
