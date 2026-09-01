package com.joinin.media.service.contract;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;

import java.util.List;

public interface ProfileService {
    void saveUserWithDefaultPictures(String identity);

    Profile getProfileByIdentity(String identity);

    List<Profile> retrieveProfilesByIdentities(List<String> identities);

    void updateProfileImage(String identity);

    void updateBackgroundImage(String identity);

    AlbumPictureUrl retrieveOldestAlbumImage(String identity);

    int retrieveAlbumImagesCount(String identity);

    void updateAlbumImageUrl(String identity, String albumImageUrl);

    void deleteOldestAlbumImage(String identity, AlbumPictureUrl albumImageUrl);
}
