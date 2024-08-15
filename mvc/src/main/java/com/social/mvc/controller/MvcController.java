package com.social.mvc.controller;

import com.social.mvc.model.Register;
import com.social.mvc.service.contract.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.ResourceAccessException;

@Controller
@AllArgsConstructor
public class MvcController {

    private final AuthenticationService authenticationService;

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

    @GetMapping("/health")
    public String health() {
        return "MVC service is HEALTHY.";
    }
}
