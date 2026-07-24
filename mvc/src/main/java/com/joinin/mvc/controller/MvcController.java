package com.joinin.mvc.controller;

import com.joinin.mvc.model.RegisterRq;
import com.joinin.mvc.service.contract.IdentityService;
import com.joinin.mvc.service.contract.MediaService;
import com.joinin.mvc.service.contract.ProfileService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.ResourceAccessException;

@Controller
@AllArgsConstructor
public class MvcController {

    private final IdentityService identityService;
    private final MediaService mediaService;
    private final ProfileService profileService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new RegisterRq());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("register") RegisterRq registerRq,
                               BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        }

        try {
            boolean isEmailUnique = identityService.isEmailUnique(registerRq.getEmail());

            if (!isEmailUnique) {
                model.addAttribute("error", "Email already exists");
                return "error";
            }

            identityService.register(registerRq);
            return "redirect:/";
        } catch (FeignException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/profile/{identity}")
    public String profile(@PathVariable("identity") String identity, Model model) {
        try {
            model.addAttribute("profileImage", mediaService.retrieveProfileImage(identity));
            model.addAttribute("backgroundImage", mediaService.retrieveProfileBackgroundImage(identity));
            model.addAttribute("albumImages", mediaService.retrieveProfileAlbumImages(identity));
            model.addAttribute("profile", profileService.retrieveProfileByIdentity(identity));
//            model.addAttribute("profile", profileService.findProfileInfoByIdentity(identity));
//            model.addAttribute("backgroundImage", imageService.findBackgroundImage(identity));
//            model.addAttribute("posts", postService.findPostsByAuthorIdentity(identity));
//            model.addAttribute("friends", relationshipService.findProfileFriends(identity));
//            model.addAttribute("onlineFriends", messageService.findProfileOnlineFriends(identity));
//            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(identity));
//            model.addAttribute("notifications", notificationService.findProfileNotifications(identity));
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
