package com.joinin.media.service;

import com.join_in.common_models.ProfileImageRpMediaService;
import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;
import com.joinin.media.service.contract.ProfileService;
import com.joinin.media.service.contract.S3MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3MediaServiceImpl implements S3MediaService {

    private final S3Client s3Client;
    private final ProfileService profileService;
    @Value("${aws.s3.bucket}")
    private String bucket;

    @Override
    public String retrieveProfileImage(String identity) {
        Profile profile = profileService.getProfileByIdentity(identity);

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucket)
                .key(profile.getProfilePictureUrl())
                .build();

        try {
            byte[] profilePictureArray = s3Client.getObjectAsBytes(request).asByteArray();
            log.info("Retrieve profile image for profile: " + profile.getIdentity());
            return "data:image/webp;base64," + Base64.getEncoder().encodeToString(profilePictureArray);
        } catch (S3Exception exception) {
            log.error("S3 error. Status: {}, code: {}, message: {}",
                    exception.statusCode(),
                    exception.awsErrorDetails() == null
                            ? null
                            : exception.awsErrorDetails().errorCode(),
                    exception.awsErrorDetails() == null
                            ? exception.getMessage()
                            : exception.awsErrorDetails().errorMessage(),
                    exception);
            if (exception.statusCode() == 404) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile picture was not found.", exception);
            }

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not read the profile picture from S3.",
                    exception
            );
        }
    }

    @Override
    public String retrieveProfileBackgroundImage(String identity) {
        Profile profile = profileService.getProfileByIdentity(identity);

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucket)
                .key(profile.getBackgroundPictureUrl())
                .build();
        try {
            byte[] backgroundImageArray = s3Client.getObjectAsBytes(request).asByteArray();
            log.info("Retrieved background image for profile: {}", profile.getIdentity());
            return "data:image/webp;base64," + Base64.getEncoder().encodeToString(backgroundImageArray);
        } catch (S3Exception exception) {
            log.error("S3 error. Status: {}, code: {}, message: {}",
                    exception.statusCode(),
                    exception.awsErrorDetails() == null
                            ? null
                            : exception.awsErrorDetails().errorCode(),
                    exception.awsErrorDetails() == null
                            ? exception.getMessage()
                            : exception.awsErrorDetails().errorMessage(),
                    exception);

            if (exception.statusCode() == 404) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Background picture was not found.", exception);
            }

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not read the background picture from S3.", exception
            );
        }
    }

    @Override
    public List<String> retrieveProfileAlbumImages(String identity) {
        Profile profile = profileService.getProfileByIdentity(identity);

        List<String> albumImages = profile.getAlbumPictureUrls()
                .stream()
                .map(AlbumPictureUrl::getUrl)
                .map(this::getImageAsBase64)
                .toList();
        log.info("Retrieve album images for profile: " + profile.getIdentity());
        return albumImages;
    }

    @Override
    public List<ProfileImageRpMediaService> retrieveProfileImagesForProfiles(List<String> identities) {
        List<Profile> profiles = profileService.retrieveProfilesByIdentities(identities);
        List<ProfileImageRpMediaService> profileImageRpMediaServiceList = profiles.stream()
                .map(profile -> {
                    String profileImage = null;

                    if (profile.getProfilePictureUrl() != null
                            && !profile.getProfilePictureUrl().isBlank()) {

                        profileImage = getImageAsBase64(profile.getProfilePictureUrl());
                    }

                    return new ProfileImageRpMediaService(profile.getIdentity(), profileImage);
                })
                .toList();
        log.info("Retrieve profile images for multiple profiles: " +
                profileImageRpMediaServiceList
                        .stream()
                        .map(ProfileImageRpMediaService::identity)
                        .collect(Collectors.joining(", ")));
        return profileImageRpMediaServiceList;
    }

    private String getImageAsBase64(String objectKey) {
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucket)
                .key(objectKey)
                .build();

        try {
            byte[] image = s3Client.getObjectAsBytes(request).asByteArray();
            return "data:image/webp;base64," + Base64.getEncoder().encodeToString(image);
        } catch (S3Exception exception) {
            log.error("Could not retrieve image: {}", objectKey, exception);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not retrieve image.", exception);
        }
    }
}