package com.joinin.mvc.service;

import com.joinin.mvc.service.contract.ReactionService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final GatewayClient gatewayClient;

    @Override
    public int retrieveReactionsCount(String identity) {
        int reactionsCount = gatewayClient.retrievePostsAndCommentsReactionsCount(identity);
        log.info("Retrieve total reactions count for profile: " + identity);
        return reactionsCount;
    }
}
