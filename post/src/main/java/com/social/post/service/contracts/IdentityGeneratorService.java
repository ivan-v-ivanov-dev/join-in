package com.social.post.service.contracts;

public interface IdentityGeneratorService {
    String generate(String userIdentity, String content, String createDate);
}
