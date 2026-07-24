package com.joinin.gateway.service;

import com.joinin.gateway.service.contract.MediaService;
import com.joinin.gateway.service.feign.MediaServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService {

    private final MediaServiceClient mediaServiceClient;

    @Override
    public String retrieveProfileImage(String identity) {
        String profileImage = mediaServiceClient.retrieveProfileImage(identity);
        log.info("Retrieve profile image from Media service for profile: " + identity);
        return profileImage;
    }

    @Override
    public String retrieveProfileBackgroundImage(String identity) {
        String backgroundImage = mediaServiceClient.retrieveProfileBackgroundImage(identity);
        log.info("Retrieve profile background image from Media service for profile: " + identity);
        return backgroundImage;
    }

    @Override
    public List<String> retrieveProfileAlbumImages(String identity) {
        List<String> albumImages = mediaServiceClient.retrieveProfileAlbumImages(identity);
        log.info("Retrieve profile album images from Media service for profile: " + identity);
        return albumImages;
    }
}
