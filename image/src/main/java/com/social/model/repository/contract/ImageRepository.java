package com.social.model.repository.contract;

import com.social.model.model.Image;

import java.util.List;

public interface ImageRepository {
    Image findProfileImage(String collection);

    Image findProfileBackgroundImage(String collection);

    List<Image> findProfileAlbumImages(String collection);

    void createCollection(String collection);
}
