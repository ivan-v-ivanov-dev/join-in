package com.social.profile.service.contrancts;

import com.social.profile.model.Profile;

public interface ProfileService {
    Profile findByIdentity(String identity);
}
