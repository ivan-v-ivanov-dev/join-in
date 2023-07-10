package com.social.profile.service.contracts;

import com.social.profile.model.Profile;
import com.social.profile.model.dto.PostDto;

import java.util.List;

public interface ProfileService {
    Profile findByIdentity(String identity);

    Profile save(Profile profile);

    List<PostDto> findAllPosts(String identity);
}
