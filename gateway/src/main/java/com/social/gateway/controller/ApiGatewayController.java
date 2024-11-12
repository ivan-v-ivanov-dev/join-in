package com.social.gateway.controller;

import com.social.gateway.service.contract.AuthenticationService;
import com.social.gateway.service.contract.ImageService;
import com.social.gateway.service.contract.ProfileService;
import com.social.model.dto.ProfileGatewayRp;
import com.social.model.dto.RegisterUserRq;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGatewayController {

    private final AuthenticationService authenticationService;
    private final ProfileService profileService;
    private final ImageService imageService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        return authenticationService.login(email, password);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("userIdentity") String userIdentity) {
        authenticationService.logout(userIdentity);
        return "redirect:/";
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserRq registerUserRq) {
        authenticationService.register(registerUserRq);
    }

    @GetMapping("/profile/{identity}")
    public ProfileGatewayRp findProfileInfoByIdentity(@PathVariable String identity) {
        return profileService.findProfileInfoByIdentity(identity);
    }

    @GetMapping("/profile/{identity}/profile-image")
    public String findProfileImage(@PathVariable String identity) {
        return imageService.findProfileImage(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
