package com.social.post.controller;

import com.social.post.service.contract.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/health")
    public String health() {
        return "Image service is HEALTHY";
    }
}
