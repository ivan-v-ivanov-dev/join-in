package com.joinin.relationship.service.feign;

import com.join_in.common_models.ProfileOnlineStatusRpMessageService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${message.service.feign.client.name}", url = "${message.service.url}")
public interface MessageServiceClient {
    @PostMapping("/profiles/online-status")
    List<ProfileOnlineStatusRpMessageService> retrieveProfilesOnlineStatuses(@RequestBody List<String> identities);
}
