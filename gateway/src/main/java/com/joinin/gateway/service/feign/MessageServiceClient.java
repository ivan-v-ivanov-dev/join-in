package com.joinin.gateway.service.feign;

import com.join_in.common_models.ConversationRpMessageService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${message.service.feign.client.name}", url = "${message.service.url}")
public interface MessageServiceClient {
    @GetMapping("/profile/{identity}/conversations")
    List<ConversationRpMessageService> retrieveConversations(@PathVariable("identity") String identity);

    @GetMapping("/profile/{identity}/online-status")
    String retrieveProfileOnlineStatus(@PathVariable("identity") String identity);
}
