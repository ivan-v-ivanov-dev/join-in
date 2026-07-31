package com.joinin.message.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private static final String OFFLINE = "OFFLINE";

    private final StringRedisTemplate redisTemplate;

    public String saveOffline(String identity) {
        if (identity != null && !identity.isBlank()) {
            redisTemplate.opsForValue().set(identity, OFFLINE);
            return redisTemplate.opsForValue().get(identity);
        }

        return "User not saved in Redis. Problems with the identity: " + identity;
    }

    public String getStatus(String identity) {
        if (identity == null || identity.isBlank()) {
            return OFFLINE;
        }

        return redisTemplate.opsForValue().get(identity);
    }
}
