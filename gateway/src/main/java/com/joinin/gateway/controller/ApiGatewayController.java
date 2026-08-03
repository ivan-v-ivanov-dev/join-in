package com.joinin.gateway.controller;

import com.join_in.common_models.*;
import com.joinin.gateway.service.contract.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApiGatewayController {

    private final IdentityService identityService;
    private final MediaService mediaService;
    private final ProfileService profileService;
    private final RelationshipService relationshipService;
    private final PostService postService;
    private final GroupService groupService;
    private final ReactionService reactionService;

    @PostMapping("/email/{email}/unique")
    public boolean isEmailUnique(@PathVariable("email") String email) {
        return identityService.isEmailUnique(email);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq) {
        identityService.registerUser(registerUserMVCRq);
    }

    @GetMapping("/profile/{identity}/profile-image")
    public String retrieveProfileImage(@PathVariable String identity) {
        return mediaService.retrieveProfileImage(identity);
    }

    @GetMapping("/profile/{identity}/background-image")
    public String retrieveProfileBackgroundImage(@PathVariable String identity) {
        return mediaService.retrieveProfileBackgroundImage(identity);
    }

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> retrieveProfileAlbumImages(@PathVariable String identity) {
        return mediaService.retrieveProfileAlbumImages(identity);
    }

    @GetMapping("/profile/{identity}")
    public ProfileRpGatewayService retrieveProfileByIdentity(@PathVariable String identity) {
        return profileService.retrieveProfileByIdentity(identity);
    }

    @GetMapping("/profile/{identity}/friends")
    public List<ProfileFriendsRpGatewayService> retrieveFriends(@PathVariable String identity) {
        return relationshipService.retrieveFriends(identity);
    }

    @GetMapping("/profile/{identity}/posts")
    public List<PostRpGatewayService> retrieveProfilePosts(@PathVariable String identity) {
        return postService.retrieveProfilePosts(identity);
    }

    @GetMapping("/profile/{identity}/joined-groups")
    public List<GroupRpGatewayService> retrieveProfileJoinedGroups(@PathVariable String identity) {
        return groupService.retrieveProfileJoinedGroups(identity);
    }

    @GetMapping("/profile/{identity}/posts/count")
    public int retrieveProfilePostsCount(@PathVariable String identity) {
        return postService.retrieveProfilePostsCount(identity);
    }

    @GetMapping("/profile/{identity}/comments/count")
    public int retrieveProfileCommentsCount(@PathVariable String identity) {
        return postService.retrieveProfileCommentsCount(identity);
    }

    @GetMapping("/profile/{identity}/friends/count")
    public int retrieveProfilesFriendsCount(@PathVariable String identity) {
        return relationshipService.retrieveFriendsCount(identity);
    }

    @GetMapping("/profile/{identity}/frienship/requests")
    public  List<ProfileFriendsRpGatewayService> retrieveFriendshipRequests(@PathVariable String identity) {
        return relationshipService.retrieveFriendshipRequests(identity);
    }

    @GetMapping("/profile/{identity}/reactions/count")
    public int retrievePostsAndCommentsReactionsCount(@PathVariable String identity) {
        return reactionService.retrievePostsAndCommentsReactionsCount(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
