package com.joinin.message.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private static final String OFFLINE = "OFFLINE";
    private static final String ONLINE = "ONLINE";

    private final StringRedisTemplate redisTemplate;

    public String saveOnline(String identity) {
        return saveStatus(identity, ONLINE);
    }

    public String saveOffline(String identity) {
        return saveStatus(identity, OFFLINE);
    }

    private String saveStatus(String identity, String status) {
        if (identity == null || identity.isBlank()) {
            return "User not saved in Redis. Problems with the identity: " + identity;
        }

        redisTemplate.opsForValue().set(identity, status);

        return status;
    }

    public String getStatus(String identity) {
        if (identity == null || identity.isBlank()) {
            return OFFLINE;
        }

        return redisTemplate.opsForValue().get(identity);
    }
}
