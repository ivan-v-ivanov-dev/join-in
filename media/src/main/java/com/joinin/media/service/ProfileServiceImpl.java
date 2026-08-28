package com.joinin.media.service;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;
import com.joinin.media.repository.ProfileRepository;
import com.joinin.media.service.contract.ImageConverterService;
import com.joinin.media.service.contract.ProfileService;
import com.joinin.media.service.contract.S3MediaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.joinin.media.service.contrants.ProfilePicConstants.*;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ImageConverterService imageConverterService;
    private final S3MediaService s3MediaService;

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

    @Override
    public List<Profile> retrieveProfilesByIdentities(List<String> identities) {
        List<Profile> profiles = profileRepository.retrieveProfilesByIdentities(identities);
        log.info("Retrieve multiple profiles by identities: " + String.join(", ", identities));
        return profiles;
    }

    @Override
    public void updateProfileImage(String identity, byte[] profileImageBytes) {
        try {
            byte[] imageAsWebpFormat = imageConverterService.convertToWebp(profileImageBytes);
            String imageName = "profile.webp";
            String mongoProfileUrl = "profile/" + identity + "/profile.webp";
            profileRepository.updateProfileImage(identity, mongoProfileUrl);
            s3MediaService.updateProfileImage(identity, imageName, imageAsWebpFormat);
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
        }
    }

    @Override
    public void updateBackgroundImage(String identity, byte[] backgroundImageBytes) {
        try {
            byte[] imageAsWebFormat = imageConverterService.convertToWebp(backgroundImageBytes);
            String imageName = "background.webp";
            String mongoBackgroundPictureUrl = "background/" + identity + "/background.webp";
            profileRepository.updateBackgroundImage(identity, mongoBackgroundPictureUrl);
            s3MediaService.updateBackgroundImage(identity, imageName, imageAsWebFormat);
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
        }
    }
}
