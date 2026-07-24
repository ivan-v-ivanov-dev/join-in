package com.joinin.gateway.controller;

import com.join_in.common_models.RegisterUserMVCRq;
import com.join_in.common_models.ProfileRpGatewayService;
import com.joinin.gateway.service.contract.IdentityService;
import com.joinin.gateway.service.contract.MediaService;
import com.joinin.gateway.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApiGatewayController {

    private final IdentityService identityService;
    private final MediaService mediaService;
    private final ProfileService profileService;

    @PostMapping("/email/{email}/unique")
    public boolean isEmailUnique(@PathVariable("email") String email) {
        return identityService.isEmailUnique(email);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq) {
        identityService.registerUser(registerUserMVCRq);
    }

    @GetMapping("/profile/{identity}/profile-image")
    public String retrieveProfileImage(@PathVariable String identity) {
        return mediaService.retrieveProfileImage(identity);
    }

    @GetMapping("/profile/{identity}/background-image")
    public String retrieveProfileBackgroundImage(@PathVariable String identity) {
        return mediaService.retrieveProfileBackgroundImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getProfileAlbumImages(@PathVariable String identity) {
        return mediaService.getProfileAlbumImages(identity);
    }

    @GetMapping("/profile/{identity}")
    public ProfileRpGatewayService retrieveProfileByIdentity(@PathVariable String identity) {
        return profileService.retrieveProfileByIdentity(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
