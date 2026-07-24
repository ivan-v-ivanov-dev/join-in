package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Profile;

public interface ProfileService {
    Profile retrieveProfileByIdentity(String identity);
}
