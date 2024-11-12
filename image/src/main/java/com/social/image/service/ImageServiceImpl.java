package com.social.image.service;

import com.social.image.model.Image;
import com.social.image.service.constants.LoggerConstants;
import com.social.image.service.constants.ServiceConstants;
import com.social.image.service.contract.ImageService;
import com.social.image.repository.contract.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public void createCollection(String identity) {
        imageRepository.createCollection(String.format(ServiceConstants.COLLECTION_TEMPLATE, identity));
        log.info(String.format(LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE, identity));
    }

    @Override
    public String findProfileImage(String identity) {
        Image profileImage = imageRepository.findProfileImage(String.format(ServiceConstants.COLLECTION_TEMPLATE, identity));
        log.info(String.format(LoggerConstants.RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE, identity));
        //TODO add default picture
        return profileImage.getImage() != null ? profileImage.getImage() : null;
    }

    @Override
    public String findProfileBackgroundImage(String identity) {
        Image backgroundImage = imageRepository.findProfileBackgroundImage(String.format(ServiceConstants.COLLECTION_TEMPLATE, identity));
        log.info(String.format(LoggerConstants.RETRIEVE_BACKGROUND_IMAGE_FOR_USER_TEMPLATE, identity));
        //TODO Add default image
        return backgroundImage.getImage() != null ? backgroundImage.getImage() : null;
    }

    @Override
    public Map<String, List<String>> findProfileAlbumImages(String identity) {
        List<Image> images = imageRepository.findProfileAlbumImages(String.format(ServiceConstants.COLLECTION_TEMPLATE, identity));
        log.info(String.format(LoggerConstants.RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE, identity));
        Map<String, List<String>> collect = images.stream()
                .collect(Collectors.groupingBy(
                        Image::getAlbumName,
                        Collectors.mapping(Image::getImage, Collectors.toList())
                ));
        return collect;
    }
}
