package com.social.profile.service.feign;

import com.social.profile.model.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostClient {

    @PostMapping("${post.publications.endpoint}")
    List<Post> findAllPostsByAuthorIdentity(@RequestParam(name = "authorIdentity") String authorIdentity);
}
