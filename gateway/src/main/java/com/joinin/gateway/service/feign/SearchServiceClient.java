package com.joinin.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${search.service.feign.client.name}", url = "${search.service.url}")
public interface SearchServiceClient {
    @GetMapping("/profile/{identity}")
    List<String> retrieveProfileSearchHistory(@PathVariable String identity);
}
