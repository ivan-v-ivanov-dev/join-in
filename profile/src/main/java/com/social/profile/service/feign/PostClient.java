package com.social.profile.service.feign;

import com.social.profile.model.dto.EditPostDto;
import com.social.profile.model.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostClient {

    @PostMapping("${post.find.all}")
    List<PostDto> findAllPostsByAuthorIdentity(@RequestParam(name = "authorIdentity") String authorIdentity);

    @PostMapping("${post.find.one}")
    EditPostDto findByPostIdentity(@RequestParam(name = "postIdentity") String postIdentity);

    @PostMapping("${post.author.posts.count}")
    int findAuthorPostsCount(@RequestParam(name = "authorIdentity") String authorIdentity);

}
