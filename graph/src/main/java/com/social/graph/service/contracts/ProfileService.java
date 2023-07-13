package com.social.graph.service.contracts;

import com.social.graph.model.Profile;

public interface ProfileService {
    Profile findByIdentity(String identity);
}
