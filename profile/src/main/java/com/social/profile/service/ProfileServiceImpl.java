package com.social.profile.service;

import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.COLLECTION_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void createCollection(String identity) {
        profileRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }
}
