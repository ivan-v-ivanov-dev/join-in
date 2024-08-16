package com.social.profile.service;

import com.social.model.dto.ProfileRp;
import com.social.profile.adapter.ApiGatewayAdapter;
import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ApiGatewayAdapter adapter;

    @Override
    public void createCollection(String identity) {
        profileRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }

    @Override
    public ProfileRp findByIdentity(String identity) {
        Profile profile = profileRepository.findByIdentity(identity);
        log.info(String.format(RETRIEVE_PROFILE_TEMPLATE, profile.getIdentity()));
        return adapter.fromProfileToProfileGatewayRp(profile, new ProfileRp());
    }
}
