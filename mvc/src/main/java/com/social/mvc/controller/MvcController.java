package com.social.mvc.controller;

import com.social.mvc.model.Register;
import com.social.mvc.service.contract.AuthenticationService;
import com.social.mvc.service.contract.ProfileService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class MvcController {

    private final AuthenticationService authenticationService;
    private final ProfileService profileService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        try {
            String profileIdentity = authenticationService.login(email, password);
            return "redirect:/profile?identity=" + profileIdentity;
        } catch (IllegalArgumentException | ResourceAccessException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("register") Register register,
                               BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        }

        try {
            authenticationService.register(register);
            return "redirect:/";
        } catch (FeignException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/logout")
    public String signOut(@RequestParam("userIdentity") String userIdentity, Model model) {
        try {
            authenticationService.logout(userIdentity);
            return "redirect:/";
        } catch (FeignException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/profile/{identity}")
    public String profile(@PathVariable("identity") String identity, Model model) {
        try {
            model.addAttribute("profile", profileService.findProfileInfoByIdentity(identity));
            return "profile";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @GetMapping("/health")
    public String health() {
        return "MVC service is HEALTHY.";
    }
}
