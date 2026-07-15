package com.joinin.gateway.controller;

import com.join_in.common_models.RegisterUserMVCRq;
import com.joinin.gateway.service.contract.IdentityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ApiGatewayController {

    private final IdentityService identityService;

    @PostMapping("/email/{email}/unique")
    public boolean isEmailUnique(@PathVariable("email") String email) {
        return identityService.isEmailUnique(email);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq) {
        identityService.registerUser(registerUserMVCRq);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
