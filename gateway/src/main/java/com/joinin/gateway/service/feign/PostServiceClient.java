package com.joinin.gateway.service.feign;

import com.join_in.common_models.PostRpPostService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostServiceClient {
    @GetMapping("/author/{identity}")
    List<PostRpPostService> retrievePostsByAuthor(@PathVariable String identity);

    @GetMapping("/author/{identity}/posts/count")
    int retrieveAuthorPostsCount(@PathVariable String identity);

    @GetMapping("/author/{identity}/comments/count")
    int retrieveAuthorCommentsCount(@PathVariable String identity);
}
