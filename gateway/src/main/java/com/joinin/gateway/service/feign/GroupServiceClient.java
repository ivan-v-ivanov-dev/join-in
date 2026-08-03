package com.joinin.gateway.service.feign;

import com.join_in.common_models.GroupRpGroupService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${group.service.feign.client.name}", url = "${group.service.url}")
public interface GroupServiceClient {
    @GetMapping("/profile/{identity}/joined-groups")
    List<GroupRpGroupService> retrieveProfileJoinedGroups(@PathVariable("identity") String identity);
}
