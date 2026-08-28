package com.joinin.media.service.contract;

import com.join_in.common_models.GroupRpImageService;
import com.join_in.common_models.ProfileImageRpMediaService;

import java.util.List;

public interface S3MediaService {
    String retrieveProfileImage(String identity);

    String retrieveProfileBackgroundImage(String identity);

    List<String> retrieveProfileAlbumImages(String identity);

    List<ProfileImageRpMediaService> retrieveProfileImagesForProfiles(List<String> identities);

    List<GroupRpImageService> retrieveGroupsImages(List<String> identities);

    String retrievePostImage(String identity);

    void updateProfileImage(String identity, String imageName, byte[] imageAsWebpFormat);

    void updateBackgroundImage(String identity, String imageName, byte[] imageAsWebFormat);
}
