package com.social.image.service;

import com.social.image.repository.contract.ImageRepository;
import com.social.image.service.constants.ServiceConstants;
import com.social.image.service.contract.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String findProfileImage(String userIdentity) {
        return imageRepository.findProfileImage(String.format(ServiceConstants.COLLECTION_TEMPLATE, userIdentity));
    }

    @Override
    public String findProfileBackgroundImage(String userIdentity) {
        return imageRepository.findProfileBackgroundImage(String.format(ServiceConstants.COLLECTION_TEMPLATE, userIdentity));
    }

    @Override
    public List<String> findProfileAlbumImage(String userIdentity) {
        return imageRepository.findProfileAlbumImage(String.format(ServiceConstants.COLLECTION_TEMPLATE, userIdentity));
    }
}
