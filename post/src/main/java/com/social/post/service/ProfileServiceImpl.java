package com.social.post.service;

import com.social.post.repository.contract.ProfileRepository;
import com.social.post.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.post.service.constants.ServiceConstant.COLLECTION_TEMPLATE;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Set<String> findAllUsersCommentingThePost(String postIdentity, String authorIdentity) {
        return profileRepository.findAllUsersCommentingThePost(postIdentity, String.format(COLLECTION_TEMPLATE, authorIdentity));
    }
}
