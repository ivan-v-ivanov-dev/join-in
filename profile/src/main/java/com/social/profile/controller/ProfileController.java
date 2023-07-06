package com.social.profile.controller;

import com.social.profile.model.dto.RegisterDto;
import com.social.profile.service.contracts.LoginService;
import com.social.profile.service.contracts.PostService;
import com.social.profile.service.contracts.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfileController {

    private final LoginService loginService;
    private final ProfileService profileService;
    private final PostService postService;

    public ProfileController(LoginService loginService,
                             ProfileService profileService,
                             PostService postService) {
        this.loginService = loginService;
        this.profileService = profileService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        try {
            String profileIndentity = loginService.login(email, password);
            return "redirect:/profile?identity=" + profileIndentity;
        } catch (IllegalArgumentException illegalArgumentException) {
            model.addAttribute("error", illegalArgumentException.getMessage());
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam("identity") String identity, Model model) {
        model.addAttribute("profile", this.profileService.findByIdentity(identity));
        return "profile";
    }

    @PostMapping("/post")
    public RedirectView post(@RequestParam("userIdentity") String userIdentity,
                             @RequestParam("content") String content,
                             RedirectAttributes attributes) {
        postService.post(userIdentity, content);
        attributes.addAttribute("identity", userIdentity);
        return new RedirectView("/");
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
