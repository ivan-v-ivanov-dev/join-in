package com.joinin.gateway.service.contract;

import com.join_in.common_models.ProfileRpGatewayService;

public interface ProfileService {
    ProfileRpGatewayService retrieveProfileByIdentity(String identity);

    String retrieveProfileNames(String identity);
}
