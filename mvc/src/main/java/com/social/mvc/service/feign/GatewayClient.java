package com.social.mvc.service.feign;

import com.social.model.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "${gateway.service.feign.client.name}", url = "${gateway.service.url}")
public interface GatewayClient {

    @PostMapping("${gateway.login.endpoint}")
    String login(@RequestParam("email") String email, @RequestParam("password") String password);

    @PostMapping("${gateway.logout.endpoint}")
    String logout(@RequestParam("userIdentity") String userIdentity);

    @PostMapping("${gateway.register.endpoint}")
    void register(@RequestBody RegisterUserRq registerUserRq);

    @GetMapping("${gateway.profile.endpoint}")
    ProfileGatewayRp findProfileInfoByIdentity(@PathVariable("identity") String identity);

    @GetMapping("${gateway.profile.image.endpoint}")
    String findProfileImage(@PathVariable String identity);

    @GetMapping("${gateway.profile.background.image.endpoint}")
    String findProfileBackgroundImage(@PathVariable String identity);

    @GetMapping("${gateway.profile.albums.endpoint}")
    Map<String, List<String>> findProfileAlbumImages(@PathVariable String identity);

    @GetMapping("${gateway.profile.posts.endpoint}")
    List<PostGatewayRp> findPostsByAuthorIdentity(@PathVariable("identity") String identity);

    @GetMapping("${gateway.profile.friends.endpoint}")
    List<FriendGatewayRp> findProfileFriends(@PathVariable("identity") String identity);

    @GetMapping("${gateway.profile.online.friends.endpoint}")
    List<FriendGatewayRp> findProfileOnlineFriends(@PathVariable("identity") String identity);

    @GetMapping("${gateway.profile.friendship.requests.endpoint}")
    List<FriendshipRequestGatewayRp> findFriendshipRequestsByProfileIdentity(@PathVariable("identity") String identity);

    @GetMapping("${gateway.profile.notifications.endpoint}")
    List<NotificationGatewayRp> findNotificationsByProfileIdentity(@PathVariable("identity") String identity);
}
