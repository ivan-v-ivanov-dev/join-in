package com.joinin.media.controller;

import com.joinin.media.service.contract.S3MediaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MediaController {

    private final S3MediaService s3MediaService;

    @GetMapping(value = "/profile/{identity}/profile-picture", produces = "image/webp")
    public byte[] getProfilePicture(@PathVariable String identity) {
        return s3MediaService.getProfilePicture(identity);
    }
}
