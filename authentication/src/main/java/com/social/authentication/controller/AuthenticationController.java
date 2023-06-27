package com.social.authentication.controller;

import com.social.authentication.model.dto.RegisterDto;
import com.social.authentication.service.contract.LoginService;
import com.social.authentication.service.contract.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.net.ConnectException;

@Controller
public class AuthenticationController {

    private final LoginService loginService;
    private final RegisterService registerService;

    public AuthenticationController(LoginService loginService,
                                    RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
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
            loginService.login(email, password);
            return "Redirect to Profile Service";
        } catch (IllegalArgumentException | ConnectException exception) {
            model.addAttribute(exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerDto") RegisterDto registerDto,
                               BindingResult errors, Model model) {
        model.addAttribute("registerDto", new RegisterDto());

        if (errors.hasErrors()) {
            return "register";
        }

        try {
            registerService.register(registerDto);
            return "redirect:/";
        } catch (IllegalArgumentException illegalArgumentException) {
            model.addAttribute(illegalArgumentException.getMessage());
            return "error";
        }
    }

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
