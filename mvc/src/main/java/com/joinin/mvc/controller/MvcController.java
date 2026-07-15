package com.joinin.mvc.controller;

import com.joinin.mvc.model.RegisterRq;
import com.joinin.mvc.service.contract.IdentityService;
import feign.FeignException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
//            model.addAttribute("profile", profileService.findProfileInfoByIdentity(identity));
//            model.addAttribute("profileImage", imageService.findProfileImage(identity));
//            model.addAttribute("backgroundImage", imageService.findBackgroundImage(identity));
//            model.addAttribute("albums", imageService.findAlbum(identity));
//            model.addAttribute("posts", postService.findPostsByAuthorIdentity(identity));
//            model.addAttribute("friends", relationshipService.findProfileFriends(identity));
//            model.addAttribute("onlineFriends", messageService.findProfileOnlineFriends(identity));
//            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(identity));
//            model.addAttribute("notifications", notificationService.findProfileNotifications(identity));
//            return "profile-cleaned";
//            return "feed";
//            return "edit-post";
//            return "create-poll";
//            return "friend-request";
//            return "notification";
//            return "edit-profile";
//            return "groups-cleaned";
//            return "single-group-cleaned";
//            return "marketplace";
            return "plugin-versions-cleaned";
//            return "plugin-versions";
//            return "create-plugin-version-cleaned";
//            return "create-plugin-cleaned";
//            return "search-results-cleaned";
//            return "chat";
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
