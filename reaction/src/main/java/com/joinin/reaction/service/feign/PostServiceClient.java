package com.joinin.reaction.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostServiceClient {

    @GetMapping("/author/{identity}/post/identities")
    List<String> retrievePostIdentitiesByAuthor(@PathVariable String identity);

    @GetMapping("/author/{identity}/comment/identities")
    List<String> retrieveCommentIdentitiesByAuthor(@PathVariable String identity);
}
