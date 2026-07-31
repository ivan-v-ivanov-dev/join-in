package com.joinin.relationship.mapper;

import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileOnlineStatusRpMessageService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.join_in.common_models.ProfileRpRelationshipService;
import com.joinin.relationship.model.ProfileNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileRelationshipMapper {

    public ProfileRpRelationshipService toProfileRpRelationshipService(ProfileNode friend,
                                                                       List<ProfileRpProfileNamesProfileService> profileNames,
                                                                       List<ProfileImageRpMediaService> profileImages,
                                                                       List<ProfileOnlineStatusRpMessageService> profileOnlineStatuses) {
        ProfileRpProfileNamesProfileService names = profileNames.stream()
                .filter(profile ->
                        profile.identity().equals(friend.getIdentity()))
                .findFirst()
                .orElse(null);

        String profileImage = profileImages.stream()
                .filter(image ->
                        image.identity().equals(friend.getIdentity()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse(null);

        String onlineStatus = profileOnlineStatuses
                .stream()
                .filter(e -> e.identity().equals(friend.getIdentity()))
                .map(ProfileOnlineStatusRpMessageService::onlineStatus)
                .findFirst()
                .orElse("OFFLINE");

        return new ProfileRpRelationshipService(
                friend.getIdentity(),
                names != null ? names.firstName() : null,
                names != null ? names.lastName() : null,
                profileImage,
                onlineStatus);
    }
}
