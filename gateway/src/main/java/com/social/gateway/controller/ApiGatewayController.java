package com.social.gateway.controller;

import com.social.gateway.service.contract.*;
import com.social.model.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGatewayController {

    private final AuthenticationService authenticationService;
    private final ProfileService profileService;
    private final ImageService imageService;
    private final PostService postService;
    private final RelationshipService relationshipService;
    private final NotificationService notificationService;
    private final MessageService messageService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        return authenticationService.login(email, password);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("userIdentity") String userIdentity) {
        authenticationService.logout(userIdentity);
        return "redirect:/";
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserRq registerUserRq) {
        authenticationService.register(registerUserRq);
    }

    @GetMapping("/profile/{identity}")
    public ProfileGatewayRp findProfileInfoByIdentity(@PathVariable String identity) {
        return profileService.findProfileInfoByIdentity(identity);
    }

    @GetMapping("/profile/{identity}/profile-image")
    public String findProfileImage(@PathVariable String identity) {
        return imageService.findProfileImage(identity);
    }

    @GetMapping("/profile/{identity}/background-image")
    public String findProfileBackgroundImage(@PathVariable String identity) {
        return imageService.findProfileBackgroundImage(identity);
    }

    @GetMapping("/profile/{identity}/album-images")
    public List<String> findProfileAlbumImages(@PathVariable String identity) {
        return imageService.findProfileAlbumImages(identity);
    }

    @GetMapping("/profile/{authorIdentity}/post/{postIdentity}")
    public PostGatewayRp findByAuthorIdentityAndPostIdentity(@PathVariable("authorIdentity") String authorIdentity,
                                                             @PathVariable("postIdentity") String postIdentity) {
        return postService.findByAuthorIdentityAndPostIdentity(authorIdentity, postIdentity);
    }

    @GetMapping("/profile/{identity}/posts")
    public List<PostGatewayRp> findPostsByAuthorIdentity(@PathVariable("identity") String identity) {
        return postService.findPostsByAuthorIdentity(identity);
    }

    @GetMapping("/profile/{identity}/friends")
    public List<FriendGatewayRp> findProfileFriends(@PathVariable("identity") String identity) {
        return relationshipService.findProfileFriends(identity);
    }

    @GetMapping("/profile/{identity}/friendship-requests")
    public List<FriendshipRequestGatewayRp> findFriendshipRequestsByProfileIdentity(@PathVariable("identity") String identity) {
        return relationshipService.findFriendshipRequestsByProfileIdentity(identity);
    }

    @GetMapping("/profile/{identity}/notifications")
    public List<NotificationGatewayRp> findNotificationsByProfileIdentity(@PathVariable("identity") String identity) {
        return notificationService.findNotificationsByProfileIdentity(identity);
    }

    @GetMapping("/profile/{identity}/online-friends")
    public List<FriendGatewayRp> findProfileOnlineFriends(@PathVariable("identity") String identity) {
        return messageService.findProfileOnlineFriends(identity);
    }

    @PostMapping("/profile/{identity}/post")
    public void post(@PathVariable("identity") String identity,
                     @RequestParam String content) {
        postService.post(identity, content);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
