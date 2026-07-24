package com.joinin.mvc.service.feign;

import com.join_in.common_models.RegisterUserMVCRq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
