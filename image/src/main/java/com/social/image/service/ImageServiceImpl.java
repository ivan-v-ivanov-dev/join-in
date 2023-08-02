package com.social.image.service;

import com.social.image.repository.contract.ImageRepository;
import com.social.image.service.contract.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.image.service.constants.LoggerConstants.*;
import static com.social.image.service.constants.ServiceConstants.COLLECTION_TEMPLATE;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String findProfileImage(String userIdentity) {
        String profileImage = imageRepository.findProfileImage(String.format(COLLECTION_TEMPLATE, userIdentity));
        log.info(String.format(RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE, userIdentity));
        return profileImage;
    }

    @Override
    public String findProfileBackgroundImage(String userIdentity) {
        String backgroundImage = imageRepository.findProfileBackgroundImage(String.format(COLLECTION_TEMPLATE, userIdentity));
        log.info(String.format(RETRIEVE_BACKGROUND_IMAGE_FOR_USER_TEMPLATE, userIdentity));
        return backgroundImage;
    }

    @Override
    public List<String> findProfileAlbumImage(String userIdentity) {
        List<String> albumImages = imageRepository.findProfileAlbumImage(String.format(COLLECTION_TEMPLATE, userIdentity));
        log.info(String.format(RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE, userIdentity));
        return albumImages;
    }

    @Override
    public void createCollection(String identity) {
        imageRepository.createCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_COLLECTION_CREATED_TEMPLATE, identity));
    }
}
