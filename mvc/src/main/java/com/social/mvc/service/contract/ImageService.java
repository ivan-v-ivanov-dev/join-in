package com.social.mvc.service.contract;

import java.util.List;

public interface ImageService {
    String findProfileImage(String identity);

    String findBackgroundImage(String identity);

    List<String> findAlbum(String identity);
}
