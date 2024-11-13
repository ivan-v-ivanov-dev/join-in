package com.social.profile.service.contract;

import com.social.model.dto.ProfileRp;

public interface ProfileService {
    void createCollection(String identity);

    ProfileRp findByIdentity(String identity);

    String findProfileNames(String identity);
}
