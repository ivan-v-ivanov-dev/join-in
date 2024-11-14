package com.social.mvc.controller;

import com.social.mvc.model.RegisterRq;
import com.social.mvc.service.contract.*;
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
    private final ImageService imageService;
    private final PostService postService;
    private final RelationshipService relationshipService;
    private final NotificationService notificationService;
    private final MessageService messageService;

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
            authenticationService.register(registerRq);
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
            model.addAttribute("profileImage", imageService.findProfileImage(identity));
            model.addAttribute("backgroundImage", imageService.findBackgroundImage(identity));
            model.addAttribute("albums", imageService.findAlbums(identity));
            model.addAttribute("posts", postService.findPostsByAuthorIdentity(identity));
//            model.addAttribute("postsCount", postService.findPostsCountByAuthorIdentity(identity));
            model.addAttribute("friends", relationshipService.findProfileFriends(identity));
//            model.addAttribute("friendsCount", relationshipService.findFriendsCount(identity));
            model.addAttribute("onlineFriends", messageService.findProfileOnlineFriends(identity));
            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(identity));
            model.addAttribute("notifications", notificationService.findProfileNotifications(identity));
//            model.addAttribute("friendshipRequestsCount", relationshipService.findFriendshipRequestsCount(identity));
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
