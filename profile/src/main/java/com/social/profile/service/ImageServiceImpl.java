package com.social.profile.service;

import com.social.profile.service.contracts.ImageService;
import com.social.profile.service.feign.ImageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.profile.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageClient imageClient;

    public ImageServiceImpl(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    @Override
    public String findProfileImage(String identity) {
        String profileImage = imageClient.findProfileImage(identity);
        log.info(String.format(RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE, identity));
        return profileImage;
    }

    @Override
    public String findProfileBackgroundImage(String identity) {
        String profileBackgroundImage = imageClient.findProfileBackgroundImage(identity);
        log.info(String.format(RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE, identity));
        return profileBackgroundImage;
    }

    @Override
    public List<String> findProfileAlbumImage(String identity) {
        List<String> profileAlbumImages = imageClient.findProfileAlbumImage(identity);
        log.info(String.format(RETRIEVE_PROFILE_ALBUM_IMAGES_FROM_IMAGE_SERVICE_TEMPLATE, identity));
        return profileAlbumImages;
    }
}
