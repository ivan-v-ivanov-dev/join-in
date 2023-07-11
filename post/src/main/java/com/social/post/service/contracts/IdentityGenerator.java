package com.social.post.service.contracts;

public interface IdentityGenerator {
    String generate(String userIdentity, String content, String createDate);
}
