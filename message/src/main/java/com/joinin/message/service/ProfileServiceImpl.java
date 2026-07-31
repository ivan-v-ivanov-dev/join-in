package com.joinin.message.service;

import com.join_in.common_models.ProfileOnlineStatusRpMessageService;
import com.joinin.message.repository.ProfileRepository;
import com.joinin.message.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfileOffline(String identity) {
        String offlineUser = profileRepository.saveOffline(identity);
        log.info("User saved in Redis. User identity: " + identity + ". Status: " + offlineUser);
    }

    @Override
    public List<ProfileOnlineStatusRpMessageService> retrieveProfilesOnlineStatuses(List<String> identities) {
        List<ProfileOnlineStatusRpMessageService> profileOnlineStatusRpMessageServices = new ArrayList<>();
        identities.forEach(identity -> {
            String status = profileRepository.getStatus(identity);
            profileOnlineStatusRpMessageServices.add(new ProfileOnlineStatusRpMessageService(identity, status));
        });
        log.info("Retrieve online status for profiles: " + String.join(", ", identities));
        return profileOnlineStatusRpMessageServices;
    }
}
