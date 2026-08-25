package com.joinin.gateway.service.contract;

import com.join_in.common_models.EditProfileGatewayRq;
import com.join_in.common_models.ProfileRpGatewayService;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    ProfileRpGatewayService retrieveProfileByIdentity(String identity);

    String retrieveProfileNames(String identity);

    void editProfile(String identity, EditProfileGatewayRq editProfileGatewayRq, MultipartFile profileImage, MultipartFile backgroundImage);
}
