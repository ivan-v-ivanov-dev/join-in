package com.social.profile.service.contracts;

import com.social.profile.model.dto.EditPostDto;

public interface PostService {
    EditPostDto findByIdentity(String postIdentity);

    void post(String userIdentity, String content);

    void edit(String postIdentity, String newContent);

    void delete(String postIdentity);
}
