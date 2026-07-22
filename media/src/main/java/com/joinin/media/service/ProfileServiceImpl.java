package com.joinin.media.service;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;
import com.joinin.media.repository.ProfileRepository;
import com.joinin.media.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.joinin.media.service.contrants.ProfilePicConstants.*;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public void saveUserWithDefaultPictures(String identity) {
        Profile profile = Profile.builder().identity(identity)
                .profilePictureUrl(PROFILE_DEFAULT_PICTURE_URL)
                .backgroundPictureUrl(BACKGROUND_DEFAULT_PICTURE_URL)
                .albumPictureUrls(List.of(AlbumPictureUrl.builder().url(ALBUM_DEFAULT_PICTURE_URL).build()))
                .build();
        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved. Profile identity: " + savedProfile.getIdentity());
    }

    public Profile getProfileByIdentity(String identity) {
        Profile profile = profileRepository.getProfileByIdentity(identity);
        log.info("Retrieve profile from database. Profile identity: " + profile.getIdentity());
        return profile;
    }
}
