package com.social.mvc.service.contract;

import com.social.mvc.model.Profile;

public interface ProfileService {
    Profile findProfileInfoByIdentity(String identity);
}
