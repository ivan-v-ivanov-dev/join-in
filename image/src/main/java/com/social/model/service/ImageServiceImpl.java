package com.social.model.service;

import com.social.model.repository.contract.ImageRepository;
import com.social.model.service.contract.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.model.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static com.social.model.service.constants.LoggerConstants.RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE;
import static com.social.model.service.constants.ServiceConstants.COLLECTION_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public void createCollection(String identity) {
        imageRepository.createCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_COLLECTION_CREATED_TEMPLATE, identity));
    }

    @Override
    public String findProfileImage(String identity) {
        String profileImage = imageRepository.findProfileImage(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE, identity));
        return profileImage;
    }
}
