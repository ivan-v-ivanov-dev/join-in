package com.joinin.group.service.feign;

import com.join_in.common_models.GroupRpImageService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${media.service.feign.client.name}", url = "${media.service.url}")
public interface MediaServiceClient {

    @PostMapping("/groups/images")
    List<GroupRpImageService> retrieveGroupsImages(@RequestBody List<String> identities);
}
