package com.joinin.media.controller;

import com.joinin.media.service.contract.S3MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MediaController {

    private final S3MediaService s3MediaService;

    @GetMapping(value = "/profile/{identity}/profile-image", produces = "image/webp")
    public byte[] getProfileImage(@PathVariable String identity) {
        return s3MediaService.getProfileImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/background-image", produces = "image/webp")
    public byte[] getProfileBackgroundImage(@PathVariable String identity) {
        return s3MediaService.getProfileBackgroundImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<byte[]> getProfileAlbumImages(@PathVariable String identity) {
        return s3MediaService.getProfileAlbumImages(identity);
    }
}
