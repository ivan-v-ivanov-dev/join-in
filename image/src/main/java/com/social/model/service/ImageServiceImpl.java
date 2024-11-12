package com.social.model.service;

import com.social.model.model.Image;
import com.social.model.repository.contract.ImageRepository;
import com.social.model.service.contract.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Image profileImage = imageRepository.findProfileImage(format(COLLECTION_TEMPLATE, identity));
        log.info(format(RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE, identity));
        //TODO add default picture
        return profileImage.getImage() != null ? profileImage.getImage() : null;
    }

    @Override
    public String findProfileBackgroundImage(String identity) {
        Image backgroundImage = imageRepository.findProfileBackgroundImage(format(COLLECTION_TEMPLATE, identity));
        log.info(format(RETRIEVE_BACKGROUND_IMAGE_FOR_USER_TEMPLATE, identity));
        //TODO Add default image
        return backgroundImage.getImage() != null ? backgroundImage.getImage() : null;
    }

    @Override
    public Map<String, List<String>> findProfileAlbumImages(String identity) {
        List<Image> images = imageRepository.findProfileAlbumImages(format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE, identity));
        Map<String, List<String>> collect = images.stream()
                .collect(Collectors.groupingBy(
                        Image::getAlbumName,
                        Collectors.mapping(Image::getImage, Collectors.toList())
                ));
        return collect;
    }
}
