package com.social.mvc.service;

import com.social.mvc.service.contract.ImageService;
import com.social.mvc.service.feign.GatewayClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Map;

import static com.social.mvc.service.constants.ExceptionConstants.GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.mvc.service.constants.LoggerConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final GatewayClient gatewayClient;

    @Override
    public String findProfileImage(String identity) {
        try {
            String profileImage = gatewayClient.findProfileImage(identity);
            log.info(format(RETRIEVE_PROFILE_IMAGE_FROM_GATEWAY_SERVICE_TEMPLATE, identity));
            return profileImage;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public String findBackgroundImage(String identity) {
        try {
            String backgroundImage = gatewayClient.findProfileBackgroundImage(identity);
            log.info(format(RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_GATEWAY_SERVICE_TEMPLATE, identity));
            return backgroundImage;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public Map<String, List<String>> findAlbums(String identity) {
        try {
            Map<String, List<String>> albums = gatewayClient.findProfileAlbumImages(identity);
            log.info(format(RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE, identity));
            return albums;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }
}
