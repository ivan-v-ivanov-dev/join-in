package com.social.mvc.service.contract;

import com.social.model.dto.ProfileGatewayRp;

public interface ProfileService {
    ProfileGatewayRp findProfileInfoByIdentity(String identity);
}
