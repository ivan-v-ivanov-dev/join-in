package com.social.post.service;

import com.social.post.repository.contract.ImageRepository;
import com.social.post.service.contract.ImageService;
import org.springframework.stereotype.Service;

import static com.social.post.service.constants.ServiceConstants.COLLECTION_TEMPLATE;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String findProfileImage(String userIdentity) {
        return imageRepository.findProfileImage(String.format(COLLECTION_TEMPLATE, userIdentity));
    }

    @Override
    public String findProfileBackgroundImage(String userIdentity) {
        return imageRepository.findProfileBackgroundImage(String.format(COLLECTION_TEMPLATE, userIdentity));
    }
}
