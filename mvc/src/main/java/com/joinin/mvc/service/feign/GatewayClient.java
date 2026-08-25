package com.joinin.mvc.service.feign;

import com.join_in.common_models.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "${gateway.service.feign.client.name}", url = "${gateway.service.url}")
public interface GatewayClient {

    @GetMapping("/health")
    String health();

    @PostMapping("/email/{email}/unique")
    boolean isEmailUnique(@PathVariable("email") String email);

    @PostMapping("/register")
    void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq);

    @GetMapping(value = "/profile/{identity}/profile-image", produces = "image/webp")
    String retrieveProfileImage(@PathVariable String identity);

    @GetMapping(value = "/profile/{identity}/background-image", produces = "image/webp")
    String retrieveProfileBackgroundImage(@PathVariable String identity);

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> retrieveProfileAlbumImages(@PathVariable String identity);

    @GetMapping("/profile/{identity}")
    ProfileRpGatewayService retrieveProfileByIdentity(@PathVariable String identity);

    @GetMapping("/profile/{identity}/names")
    String retrieveProfileNames(@PathVariable String identity);

    @GetMapping("/profile/{identity}/friends")
    List<ProfileFriendsRpGatewayService> retrieveFriends(@PathVariable String identity);

    @GetMapping("/profile/{identity}/posts")
    List<PostRpGatewayService> retrieveProfilePosts(@PathVariable String identity);

    @GetMapping("/profile/{identity}/joined-groups")
    List<GroupRpGatewayService> retrieveProfileJoinedGroups(@PathVariable String identity);

    @GetMapping("/profile/{identity}/suggested-groups")
    List<GroupRpGatewayService> retrieveSuggestedGroups(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/frienship/requests")
    List<ProfileFriendsRpGatewayService> retrieveFriendshipRequests(@PathVariable String identity);

    @GetMapping("/profile/{identity}/posts/count")
    int retrieveProfilePostsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/comments/count")
    int retrieveProfileCommentsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/reactions/count")
    int retrievePostsAndCommentsReactionsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/friends/count")
    int retrieveProfilesFriendsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/search/history")
    List<String> retrieveProfileSearchKeywords(@PathVariable String identity);

    @GetMapping("/profile/{identity}/notifications")
    List<NotificationRpGatewayService> retrieveProfileNotifications(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/family/members")
    List<FamilyMemberRpGatewayService> retrieveProfileFamilyMembers(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/conversations")
    List<ConversationRpGatewayService> retrieveProfileConversations(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/online-status")
    String retrieveProfileOnlineStatus(@PathVariable("identity") String identity);

    @PostMapping("/profile/{identity}/online")
    void updateProfileOnlineStatus(@PathVariable("identity") String identity);

    @PostMapping("/profile/{identity}/offline")
    void updateProfileOfflineStatus(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/friend/suggestions")
    List<ProfileFriendsRpGatewayService> retrieveFriendSuggestions(@PathVariable String identity);

    @GetMapping("/profile/{identity}/feed")
    List<PostRpGatewayService> retrieveProfileFeedPosts(@PathVariable String identity);

    @PostMapping("/profile/{identity}/edit")
    void editProfile(@PathVariable String identity,
                     @RequestBody EditProfileGatewayRq editProfileGatewayRq,
                     @RequestPart(value = "profileImage", required = false) MultipartFile profileImage,
                     @RequestPart(value = "backgroundImage", required = false) MultipartFile backgroundImage);
}
