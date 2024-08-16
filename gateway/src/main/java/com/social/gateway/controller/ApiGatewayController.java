package com.social.gateway.controller;

import com.social.gateway.service.contract.AuthenticationService;
import com.social.model.dto.RegisterUserRq;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGatewayController {

    private final AuthenticationService authenticationService;

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

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
