package com.social.image.controller;

import com.social.image.service.contract.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/profile-image")
    public String findProfileImage(@RequestParam("userIdentity") String userIdentity) {
        return imageService.findProfileImage(userIdentity);
    }

    @PostMapping("/profile-background-image")
    public String findProfileBackgroundImage(@RequestParam("userIdentity") String userIdentity) {
        return imageService.findProfileBackgroundImage(userIdentity);
    }

    @PostMapping("/profile-album-images")
    public List<String> findProfileAlbumImage(@RequestParam("userIdentity") String userIdentity) {
        return imageService.findProfileAlbumImage(userIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Image service is HEALTHY";
    }
}
