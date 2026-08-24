package com.joinin.message.service.contract;

import com.join_in.common_models.ProfileOnlineStatusRpMessageService;

import java.util.List;

public interface ProfileService {
    void createProfileOffline(String identity);

    List<ProfileOnlineStatusRpMessageService> retrieveProfilesOnlineStatuses(List<String> identities);

    String retrieveProfileOnlineStatus(String identity);

    void updateProfileOnlineStatus(String identity);

    void updateProfileOfflineStatus(String identity);
}
