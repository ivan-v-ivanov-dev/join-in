package com.social.model.controller;

import com.social.model.service.contract.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/profile/{identity}")
    public String findProfileImage(@PathVariable String identity) {
        return imageService.findProfileImage(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Image service is HEALTHY";
    }
}
