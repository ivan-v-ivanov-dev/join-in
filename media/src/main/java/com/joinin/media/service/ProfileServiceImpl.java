package com.joinin.media.service;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;
import com.joinin.media.repository.ProfileRepository;
import com.joinin.media.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public List<Profile> retrieveProfilesByIdentities(List<String> identities) {
        List<Profile> profiles = profileRepository.retrieveProfilesByIdentities(identities);
        log.info("Retrieve multiple profiles by identities: " + String.join(", ", identities));
        return profiles;
    }

    @Override
    public void updateProfileImage(String identity) {
        String mongoProfileUrl = "profile/" + identity + "/profile.webp";
        profileRepository.updateProfileImage(identity, mongoProfileUrl);
    }

    @Override
    public void updateBackgroundImage(String identity) {
        String mongoBackgroundPictureUrl = "background/" + identity + "/background.webp";
        profileRepository.updateBackgroundImage(identity, mongoBackgroundPictureUrl);
    }

    @Override
    public int retrieveAlbumImagesCount(String identity) {
        Profile profile = profileRepository.getProfileByIdentity(identity);
        int albumImagesCount = profile.getAlbumPictureUrls().size();
        log.info("Retrieve profile album images count. Profile identity: " + identity);
        return albumImagesCount;
    }

    @Override
    public AlbumPictureUrl retrieveOldestAlbumImage(String identity) {
        return profileRepository.retrieveOldestAlbumImage(identity);
    }

    @Override
    public void deleteOldestAlbumImage(String identity, AlbumPictureUrl albumImageUrl) {
        profileRepository.deleteOldestAlbumImage(identity, albumImageUrl);
    }

    @Override
    public void updateAlbumImageUrl(String identity, String albumImageUrl) {
        AlbumPictureUrl albumImage = AlbumPictureUrl.builder()
                .url(albumImageUrl)
                .uploadedOn(LocalDateTime.now())
                .build();
        profileRepository.updateAlbumImageUrl(identity, albumImage);
        log.info("Update profile album image URL. Profile: " + identity + " Image URL: " + albumImage.getUrl());
    }
}
