package com.joinin.mvc.service;

import com.joinin.mvc.service.contract.MediaService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService {

    private final GatewayClient gatewayClient;

    @Override
    public String retrieveProfileImage(String identity) {
        String profileImage = gatewayClient.retrieveProfileImage(identity);
        log.info("Retrieve profile image from API Gateway for profile: " + identity);
        return profileImage;
    }

    @Override
    public String retrieveProfileBackgroundImage(String identity) {
        String backgroundImage = gatewayClient.retrieveProfileBackgroundImage(identity);
        log.info("Retrieve profile background image from API Gateway for profile: " + identity);
        return backgroundImage;
    }

    @Override
    public List<String> retrieveProfileAlbumImages(String identity) {
        List<String> albumImages = gatewayClient.retrieveProfileAlbumImages(identity);
        log.info("Retrieve profile album images from API Gateway for profile: " + identity);
        return albumImages;
    }

    @Override
    public void updateProfileImage(String identity, MultipartFile profileImage) {
        gatewayClient.updateProfileImage(identity, profileImage);
        log.info("Update profile image for profile: " + identity);
    }

    @Override
    public void updateBackgroundImage(String identity, MultipartFile backgroundImage) {
        gatewayClient.updateBackgroundImage(identity, backgroundImage);
        log.info("Update background image for profile: " + identity);
    }
}
