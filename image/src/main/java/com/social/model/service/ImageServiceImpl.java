package com.social.model.service;

import com.social.model.repository.contract.ImageRepository;
import com.social.model.service.contract.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.model.service.constants.LoggerConstants.*;
import static com.social.model.service.constants.ServiceConstants.COLLECTION_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public void createCollection(String identity) {
        imageRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, identity));
    }

    @Override
    public String findProfileImage(String identity) {
        String profileImage = imageRepository.findProfileImage(format(COLLECTION_TEMPLATE, identity));
        log.info(format(RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE, identity));
        return profileImage;
    }

    @Override
    public String findProfileBackgroundImage(String identity) {
        String backgroundImage = imageRepository.findProfileBackgroundImage(format(COLLECTION_TEMPLATE, identity));
        log.info(format(RETRIEVE_BACKGROUND_IMAGE_FOR_USER_TEMPLATE, identity));
        return backgroundImage;
    }
}
