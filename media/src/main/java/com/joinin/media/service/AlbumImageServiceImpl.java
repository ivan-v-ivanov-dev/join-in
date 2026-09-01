package com.joinin.media.service;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.service.contract.AlbumImageService;
import com.joinin.media.service.contract.ProfileService;
import com.joinin.media.service.contract.S3MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumImageServiceImpl implements AlbumImageService {

    private final ProfileService profileService;
    private final S3MediaService s3MediaService;

    @Override
    public void uploadAlbumImage(String identity, byte[] imageBytes) {
        int albumImagesCount = profileService.retrieveAlbumImagesCount(identity);
        String imageName;
        if (albumImagesCount >= 12) {
            //retrieve oldest album image
            AlbumPictureUrl oldestAlbumPictureUrl = profileService.retrieveOldestAlbumImage(identity);
            // reuse the filename of the oldest image
            imageName = extractImageName(oldestAlbumPictureUrl.getUrl());
            //s3 delete oldest image
            s3MediaService.deleteAlbumImage(oldestAlbumPictureUrl.getUrl());
            // delete from mongo oldest
            profileService.deleteOldestAlbumImage(identity, oldestAlbumPictureUrl);
        } else {
            imageName = "album_" + (albumImagesCount + 1) + ".webp";
        }
        // s3 upload new image
        String albumImageUrl = s3MediaService.uploadAlbumImage(identity, imageBytes, imageName);
        // store the new url in database
        profileService.updateAlbumImageUrl(identity, albumImageUrl);
    }

    private String extractImageName(String objectKey) {
        return objectKey.substring(objectKey.lastIndexOf("/") + 1);
    }
}
