package com.social.gateway.service.contract;

import com.social.model.dto.ProfileGatewayRp;

public interface ProfileService {
    ProfileGatewayRp findProfileInfoByIdentity(String identity);
}
