package com.joinin.profile.service;

import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.join_in.common_models.ProfileRpProfileService;
import com.join_in.kafka_models.messages.UpdateProfile;
import com.joinin.profile.mapper.ProfileMapper;
import com.joinin.profile.models.Profile;
import com.joinin.profile.repository.ProfileRepository;
import com.joinin.profile.service.contract.ProfileService;
import com.joinin.profile.service.feign.IdentityServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final IdentityServiceClient identityServiceClient;

    @Override
    public void save(Profile profile) {
        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved in database. Profile identity: " + savedProfile.getIdentity());
    }

    @Override
    public ProfileRpProfileService retrieveProfileByIdentity(String identity) {
        Profile profile = profileRepository.retrieveProfileByIdentity(identity);
        log.info("Retrieve profile by identity: " + profile.getIdentity());
        String email = identityServiceClient.retrieveEmailByIdentity(identity);
        log.info("Retrieve email from Identity Service by profile identity: " + email);
        return profileMapper.fromProfiletoProfileRpProfileService(profile, email);
    }

    @Override
    public String retrieveProfileNames(String identity) {
        Profile profile = profileRepository.retrieveProfileByIdentity(identity);
        log.info("Retrieve profile by identity: " + profile.getIdentity());
        String names = String.format("%s %s", profile.getFirstName(), profile.getLastName());
        log.info("Retrieve profile names: " + names);
        return names;
    }

    @Override
    public List<ProfileRpProfileNamesProfileService> retrieveProfilesNames(List<String> identities) {
        List<Profile> profiles = profileRepository.retrieveProfilesByIdentities(identities);
        log.info("Retrieve profiles by identities: " +
                profiles.stream()
                        .map(Profile::getIdentity)
                        .collect(Collectors.joining(", ")));
        return profiles.stream()
                .map(e -> new ProfileRpProfileNamesProfileService(
                        e.getIdentity(),
                        e.getFirstName(),
                        e.getLastName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void update(UpdateProfile updateProfileMessage) {
        Profile profile = profileMapper.fromUpdateProfiletoProfile(updateProfileMessage);
        profileRepository.update(profile);
        log.info("Update profile: " + profile.getIdentity());
    }
}
