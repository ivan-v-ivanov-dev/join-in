package com.social.image.controller;

import com.social.image.service.contract.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/profile/{identity}")
    public String findProfileImage(@PathVariable String identity) {
        return imageService.findProfileImage(identity);
    }

    @GetMapping("/profile/{identity}/background-image")
    public String findProfileBackgroundImage(@PathVariable String identity) {
        return imageService.findProfileBackgroundImage(identity);
    }

    @GetMapping("/profile/{identity}/albums")
    public Map<String, List<String>> findProfileAlbumImages(@PathVariable String identity) {
        return imageService.findProfileAlbumImages(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Image service is HEALTHY";
    }
}
