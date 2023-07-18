package com.social.post.service.contract;

import java.util.List;

public interface ImageService {
    String findProfileImage(String userIdentity);

    String findProfileBackgroundImage(String userIdentity);

    List<String> findProfileAlbumImage(String userIdentity);
}
