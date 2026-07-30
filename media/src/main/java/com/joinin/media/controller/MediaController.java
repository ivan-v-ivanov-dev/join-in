package com.joinin.media.controller;

import com.join_in.common_models.ProfileImageRpMediaService;
import com.joinin.media.service.contract.S3MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MediaController {

    private final S3MediaService s3MediaService;

    @GetMapping(value = "/profile/{identity}/profile-image", produces = "image/webp")
    public String retrieveProfileImage(@PathVariable String identity) {
        return s3MediaService.retrieveProfileImage(identity);
    }

    @PostMapping(value = "/profiles/profile-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfileImageRpMediaService> retrieveProfileImagesForProfiles(@RequestBody List<String> identities) {
        return s3MediaService.retrieveProfileImagesForProfiles(identities);
    }

    @GetMapping(value = "/profile/{identity}/background-image", produces = "image/webp")
    public String retrieveProfileBackgroundImage(@PathVariable String identity) {
        return s3MediaService.retrieveProfileBackgroundImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> retrieveProfileAlbumImages(@PathVariable String identity) {
        return s3MediaService.retrieveProfileAlbumImages(identity);
    }
}
