package com.social.profile.controller;

import com.social.profile.model.Register;
import com.social.profile.service.contracts.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;

@Controller
public class ProfileController {

    private final AuthenticationService authenticationService;
    private final RegisterService registerService;
    private final ProfileService profileService;
    private final PostService postService;
    private final CommentService commentService;
    private final ImageService imageService;
    private final RelationshipService relationshipService;
    private final ReactionService reactionService;
    private final NotificationService notificationService;
    private final MessageService messageService;

    public ProfileController(AuthenticationService authenticationService,
                             RegisterService registerService,
                             ProfileService profileService,
                             PostService postService,
                             CommentService commentService,
                             ImageService imageService,
                             RelationshipService relationshipService,
                             ReactionService reactionService,
                             NotificationService notificationService,
                             MessageService messageService) {
        this.authenticationService = authenticationService;
        this.registerService = registerService;
        this.profileService = profileService;
        this.postService = postService;
        this.commentService = commentService;
        this.imageService = imageService;
        this.relationshipService = relationshipService;
        this.reactionService = reactionService;
        this.notificationService = notificationService;
        this.messageService = messageService;
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
            String profileIndentity = authenticationService.login(email, password);
            return "redirect:/profile?identity=" + profileIndentity;
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
        registerService.register(register);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam("identity") String identity, Model model) {
        try {
            model.addAttribute("profile", profileService.findByIdentity(identity));
            model.addAttribute("profileImage", imageService.findProfileImage(identity));
            model.addAttribute("backgroundImage", imageService.findProfileBackgroundImage(identity));
            model.addAttribute("albumImages", imageService.findProfileAlbumImage(identity));
            model.addAttribute("posts", postService.findUserPosts(identity));
            model.addAttribute("postsCount", postService.findUserPostsCount(identity));
            model.addAttribute("friends", relationshipService.findFriends(identity));
            model.addAttribute("friendsCount", relationshipService.findFriendsCount(identity));
            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(identity));
            model.addAttribute("friendshipRequestsCount", relationshipService.findFriendshipRequestsCount(identity));
            model.addAttribute("notifications", notificationService.findUserNotifications(identity));
            model.addAttribute("onlineFriends", messageService.onlineFriends(identity));
            return "profile";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @PostMapping("/post")
    public String post(@RequestParam("userIdentity") String userIdentity,
                       @RequestParam("content") String content) {
        postService.post(userIdentity, content);
        return "redirect:/feed?userIdentity=" + userIdentity;
    }

    @PostMapping("/post/view")
    public String editPostView(@RequestParam("postIdentity") String postIdentity,
                               @RequestParam("authorIdentity") String authorIdentity,
                               Model model) {
        try {
            model.addAttribute("post", postService.findByIdentity(postIdentity, authorIdentity));
            return "edit-post";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @PostMapping("/post/edit")
    public String editPost(@RequestParam("userIdentity") String userIdentity,
                           @RequestParam("postIdentity") String postIdentity,
                           @RequestParam("newContent") String newContent) {
        postService.edit(postIdentity, userIdentity, newContent);
        return "redirect:/profile?identity=" + userIdentity;
    }

    @PostMapping("/post/delete")
    public String deletePost(@RequestParam("userIdentity") String userIdentity,
                             @RequestParam("postIdentity") String postIdentity) {
        postService.delete(postIdentity, userIdentity);
        return "redirect:/profile?identity=" + userIdentity;
    }

    @PostMapping("/comment")
    public String comment(@RequestParam("commentAuthorIdentity") String commentAuthorIdentity,
                          @RequestParam("postIdentity") String postIdentity,
                          @RequestParam("postAuthorIdentity") String postAuthorIdentity,
                          @RequestParam("comment") String comment) {
        commentService.comment(commentAuthorIdentity, postIdentity, postAuthorIdentity, comment);
        return "redirect:/profile?identity=" + commentAuthorIdentity;
    }

    @PostMapping("/post/like")
    public String likeAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                            @RequestParam("postIdentity") String postIdentity,
                            @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.likePost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/post/dislike")
    public String dislikeAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                               @RequestParam("postIdentity") String postIdentity,
                               @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.dislikePost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/post/star")
    public String starAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                            @RequestParam("postIdentity") String postIdentity,
                            @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.starPost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/comment/like")
    public String likeAComment(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                               @RequestParam("commentIdentity") String commentIdentity,
                               @RequestParam("postIdentity") String postIdentity,
                               @RequestParam("commentAuthorIdentity") String commentAuthorIdentity) {
        reactionService.likeComment(reactingUserIdentity, commentIdentity, postIdentity, commentAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/comment/dislike")
    public String dislikeAComment(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                                  @RequestParam("commentIdentity") String commentIdentity,
                                  @RequestParam("postIdentity") String postIdentity,
                                  @RequestParam("commentAuthorIdentity") String commentAuthorIdentity) {
        reactionService.dislikeComment(reactingUserIdentity, commentIdentity, postIdentity, commentAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/friendship-request/confirm")
    public String confirmFriendship(@RequestParam("recipientUserIdentity") String recipientUserIdentity,
                                    @RequestParam("senderUserIdentity") String senderUserIdentity) {
        relationshipService.confirmFriendship(recipientUserIdentity, senderUserIdentity);
        return "redirect:/profile?identity=" + recipientUserIdentity;
    }

    @PostMapping("/friendship-request/decline")
    public String deleteFriendship(@RequestParam("recipientUserIdentity") String recipientUserIdentity,
                                   @RequestParam("senderUserIdentity") String senderUserIdentity) {
        relationshipService.declineFriendship(recipientUserIdentity, senderUserIdentity);
        return "redirect:/profile?identity=" + recipientUserIdentity;
    }

    @PostMapping("/unfriend")
    public String unfriend(@RequestParam("recipientUserIdentity") String recipientUserIdentity,
                           @RequestParam("senderUserIdentity") String senderUserIdentity) {
        relationshipService.unfriend(recipientUserIdentity, senderUserIdentity);
        return "redirect:/profile?identity=" + senderUserIdentity;
    }

    @PostMapping("/notifications")
    public String notifications(@RequestParam("userIdentity") String userIdentity, Model model) {
        try {
            model.addAttribute("profileIdentity", userIdentity);
            model.addAttribute("profileImage", imageService.findProfileImage(userIdentity));
            model.addAttribute("profileNames", profileService.findProfileNames(userIdentity));
            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(userIdentity));
            model.addAttribute("friendshipRequestsCount", relationshipService.findFriendshipRequestsCount(userIdentity));
            model.addAttribute("notifications", notificationService.findUserNotifications(userIdentity));
            model.addAttribute("onlineFriends", messageService.onlineFriends(userIdentity));
            return "notifications";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @PostMapping("/feed")
    public String feed(@RequestParam("userIdentity") String userIdentity, Model model) {
        try {
            model.addAttribute("profileIdentity", userIdentity);
            model.addAttribute("profileImage", imageService.findProfileImage(userIdentity));
            model.addAttribute("profileNames", profileService.findProfileNames(userIdentity));
            model.addAttribute("friendshipRequests", relationshipService.findFriendshipRequests(userIdentity));
            model.addAttribute("friendshipRequestsCount", relationshipService.findFriendshipRequestsCount(userIdentity));
            model.addAttribute("notifications", notificationService.findUserNotifications(userIdentity));
            model.addAttribute("friendSuggestions", relationshipService.findFriendSuggestions(userIdentity));
            model.addAttribute("posts", postService.findFeedPosts(userIdentity));
            model.addAttribute("onlineFriends", messageService.onlineFriends(userIdentity));
            return "feed";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("userIdentity") String userIdentity, Model model) {
        try {
            model.addAttribute("profileIdentity", userIdentity);
            model.addAttribute("profileImage", imageService.findProfileImage(userIdentity));
            model.addAttribute("profileNames", profileService.findProfileNames(userIdentity));
            model.addAttribute("onlineFriends", messageService.onlineFriends(userIdentity));
            model.addAttribute("directChatHistory", messageService.findUserDirectChatHistory(userIdentity));
            return "chat";
        } catch (ResourceAccessException resourceAccessException) {
            model.addAttribute("error", resourceAccessException.getMessage());
            return "error";
        }
    }

    @PostMapping("/chat/message")
    public String postChatMessage(@RequestParam("messageContent") String messageContent,
                                  @RequestParam("chatIdentity") String chatIdentity,
                                  @RequestParam("senderIdentity") String senderIdentity) {
        messageService.send(messageContent, chatIdentity, senderIdentity);
        return "redirect:/chat?userIdentity=" + senderIdentity;
    }

    @GetMapping("/signout")
    public String signOut(@RequestParam("userIdentity") String userIdentity) {
        authenticationService.logout(userIdentity);
        return "redirect:/";
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
