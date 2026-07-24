package com.joinin.gateway.controller;

import com.join_in.common_models.RegisterUserMVCRq;
import com.joinin.gateway.service.contract.IdentityService;
import com.joinin.gateway.service.contract.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApiGatewayController {

    private final IdentityService identityService;
    private final MediaService mediaService;

    @PostMapping("/email/{email}/unique")
    public boolean isEmailUnique(@PathVariable("email") String email) {
        return identityService.isEmailUnique(email);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq) {
        identityService.registerUser(registerUserMVCRq);
    }

    @GetMapping(value = "/profile/{identity}/profile-image", produces = "image/webp")
    public String retrieveProfileImage(@PathVariable String identity) {
        return mediaService.retrieveProfileImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/background-image", produces = "image/webp")
    public String retrieveProfileBackgroundImage(@PathVariable String identity) {
        return mediaService.retrieveProfileBackgroundImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getProfileAlbumImages(@PathVariable String identity) {
        return mediaService.getProfileAlbumImages(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
