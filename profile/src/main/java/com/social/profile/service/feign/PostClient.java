package com.social.profile.service.feign;

import com.social.profile.model.EditPost;
import com.social.profile.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostClient {

    @PostMapping("${post.find.all}")
    List<Post> findAllPostsByAuthorIdentity(@RequestParam(name = "authorIdentity") String authorIdentity);

    @PostMapping("${post.find.one}")
    EditPost findByPostIdentity(@RequestParam(name = "postIdentity") String postIdentity,
                                @RequestParam(name = "authorIdentity") String authorIdentity);

    @PostMapping("${post.author.posts.count}")
    int findAuthorPostsCount(@RequestParam(name = "authorIdentity") String authorIdentity);

}
