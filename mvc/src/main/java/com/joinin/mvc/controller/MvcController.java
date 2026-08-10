package com.joinin.mvc.controller;

import com.joinin.mvc.model.RegisterRq;
import com.joinin.mvc.service.contract.*;
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
    private final MediaService mediaService;
    private final ProfileService profileService;
    private final RelationshipService relationshipService;
    private final PostService postService;
    private final GroupService groupService;
    private final ReactionService reactionService;
    private final SearchService searchService;
    private final NotificationService notificationService;
    private final MessageService messageService;

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
            model.addAttribute("friends", relationshipService.retrieveFriends(identity));
            model.addAttribute("posts", postService.retrieveProfilePosts(identity));
            model.addAttribute("groups", groupService.retrieveProfileJoinedGroups(identity));
            model.addAttribute("friendshipRequests", relationshipService.retrieveFriendshipRequests(identity));
            model.addAttribute("postsCount", postService.retrievePostsCount(identity));
            model.addAttribute("commentsCount", postService.retrieveCommentsCount(identity));
            model.addAttribute("reactionsCount", reactionService.retrieveReactionsCount(identity));
            model.addAttribute("friendsCount", relationshipService.retrieveFriendsCount(identity));
            model.addAttribute("searchKeywords", searchService.retrieveProfileSearchKeywords(identity));
            model.addAttribute("notifications", notificationService.retrieveProfileNotifications(identity));
            model.addAttribute("familyMembers", relationshipService.retrieveProfileFamilyMembers(identity));
            model.addAttribute("conversations", messageService.retrieveConversations(identity));
            return "profile";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @GetMapping("/profile/{identity}/feed")
    public String feed(@PathVariable("identity") String identity, Model model) {
        try {
            model.addAttribute("profileIdentity", identity);
            model.addAttribute("profileNames", profileService.retrieveProfileNames(identity));
            model.addAttribute("profileImage", mediaService.retrieveProfileImage(identity));
            model.addAttribute("searchKeywords", searchService.retrieveProfileSearchKeywords(identity));
            model.addAttribute("friendshipRequests", relationshipService.retrieveFriendshipRequests(identity));
            model.addAttribute("notifications", notificationService.retrieveProfileNotifications(identity));
            return "feed";
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
