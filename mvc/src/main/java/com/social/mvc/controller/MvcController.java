package com.social.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new com.social.mvc.model.Register());
        return "register";
    }

    @GetMapping("/health")
    public String health() {
        return "MVC service is HEALTHY.";
    }
}
