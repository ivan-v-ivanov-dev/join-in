package com.social.gateway.service.feign;

import com.social.model.dto.PostRp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostClient {

    @GetMapping("${post.author.endpoint}")
    ResponseEntity<PostRp> findByAuthorIdentityAndPostIdentity(@PathVariable("authorIdentity") String authorIdentity,
                                                               @PathVariable("postIdentity") String postIdentity);
}