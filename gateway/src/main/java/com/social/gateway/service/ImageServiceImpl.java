package com.social.gateway.service;

import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.feign.ImageClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.gateway.service.constants.ExceptionConstants.IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.gateway.service.constants.LoggerConstants.*;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageClient imageClient;

    @Override
    public String findProfileImage(String identity) {
        try {
            String profileImage = imageClient.findProfileImage(identity);
            log.info(String.format(RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE, identity));
            return profileImage;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }

    }

    @Override
    public String findProfileBackgroundImage(String identity) {
        try {
            String backgroundImage = imageClient.findProfileBackgroundImage(identity);
            log.info(String.format(RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE, identity));
            return backgroundImage;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public List<String> findProfileAlbumImages(String identity) {
        try {
            List<String> album = imageClient.findProfileAlbumImages(identity);
            log.info(String.format(RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE, identity));
            return album;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }
}
