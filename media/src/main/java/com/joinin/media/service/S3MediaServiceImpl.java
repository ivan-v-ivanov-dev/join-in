package com.joinin.media.service;

import com.join_in.common_models.GroupRpImageService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Group;
import com.joinin.media.model.Post;
import com.joinin.media.model.Profile;
import com.joinin.media.service.contract.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3MediaServiceImpl implements S3MediaService {

    private static final String PROFILE_FOLDER = "profile";
    private static final String BACKGROUND_FOLDER = "background";
    private static final String ALBUM_FOLDER = "album";
    private static final String POST_FOLDER = "posts";
    private static final String PROFILE_IMAGE_NAME = "profile.webp";
    private static final String BACKGROUND_IMAGE_NAME = "background.webp";
    private static final String ALBUM_IMAGE_TYPE = "album image";

    private final S3Client s3Client;
    private final ProfileService profileService;
    private final GroupService groupService;
    private final PostService postService;
    private final ImageConverterService imageConverterService;

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

    @Override
    public List<GroupRpImageService> retrieveGroupsImages(List<String> identities) {
        List<Group> groups = groupService.retrieveGroups(identities);

        if (groups.isEmpty()) {
            return new ArrayList<>();
        }

        List<GroupRpImageService> groupImages = groups.stream()
                .map(group -> {
                    String imageBase64 = null;

                    if (group.getImageUrl() != null && !group.getImageUrl().isBlank()) {
                        imageBase64 = getImageAsBase64(group.getImageUrl());
                    }

                    return new GroupRpImageService(group.getIdentity(), imageBase64);
                })
                .toList();

        log.info("Retrieved images for groups: {}",
                groupImages.stream()
                        .map(GroupRpImageService::identity)
                        .collect(Collectors.joining(", ")));

        return groupImages;
    }

    @Override
    public String retrievePostImage(String identity) {
        Post post = postService.retrieveByIdentity(identity);

        if (post == null) {
            return "No image found";
        }

        String imageObjectKey = post.getImageUrl();
        String postImage = getImageAsBase64(imageObjectKey);

        log.info("Retrieved image for post: {}, S3 key: {}", post.getIdentity(), imageObjectKey);

        return postImage;
    }

    @Override
    public void updateProfileImage(String identity, byte[] bytes) {
        uploadImage(identity, bytes, PROFILE_FOLDER, PROFILE_IMAGE_NAME, "profile picture");
    }

    @Override
    public void updateBackgroundImage(String identity, byte[] bytes) {
        uploadImage(identity, bytes, BACKGROUND_FOLDER, BACKGROUND_IMAGE_NAME, "background picture");
    }

    @Override
    public void deleteAlbumImage(String objectKey) {
        DeleteObjectRequest request = DeleteObjectRequest.builder()
                .bucket(bucket)
                .key(objectKey)
                .build();

        try {
            s3Client.deleteObject(request);
            log.info("Deleted album image from S3. Key: {}", objectKey);
        } catch (S3Exception exception) {
            log.error(
                    "Could not delete album image from S3. Key: {}, status: {}, code: {}, message: {}",
                    objectKey,
                    exception.statusCode(),
                    exception.awsErrorDetails() == null
                            ? null
                            : exception.awsErrorDetails().errorCode(),
                    exception.awsErrorDetails() == null
                            ? exception.getMessage()
                            : exception.awsErrorDetails().errorMessage(),
                    exception);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not delete album image from S3.", exception);
        }
    }

    @Override
    public String uploadAlbumImage(String identity, byte[] bytes, String imageName) {
        return uploadImage(identity, bytes, ALBUM_FOLDER, imageName, ALBUM_IMAGE_TYPE);
    }

    @Override
    public void uploadPostImage(String postIdentity, String imageIdentity, byte[] imageBytes) {
        if (imageBytes == null || imageBytes.length == 0) {
            log.error("Post image cannot be empty");
            return;
        }

        try {
            byte[] webpBytes = imageConverterService.convertToWebp(imageBytes);
            String objectKey = POST_FOLDER + "/" + imageIdentity + ".webp";
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .contentType("image/webp")
                    .build();

            s3Client.putObject(request, RequestBody.fromBytes(webpBytes));
            log.info("Uploaded post image. Identity: {}, S3 key: {}", imageIdentity, objectKey);
            postService.savePost(postIdentity, objectKey);
        } catch (IOException exception) {
            log.error("Could not convert post image to WebP. Identity: {}", imageIdentity, exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Could not convert post image to WebP.", exception);
        } catch (S3Exception exception) {
            log.error("Could not upload post image. Identity: {}, status: {}, code: {}, message: {}",
                    imageIdentity,
                    exception.statusCode(),
                    exception.awsErrorDetails() == null
                            ? null
                            : exception.awsErrorDetails().errorCode(),
                    exception.awsErrorDetails() == null
                            ? exception.getMessage()
                            : exception.awsErrorDetails().errorMessage(),
                    exception
            );
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not upload post image to S3.", exception);
        }
    }

    private String uploadImage(String identity, byte[] imageBytes, String folder, String imageName, String imageType) {
        try {
            byte[] webpBytes = imageConverterService.convertToWebp(imageBytes);
            String objectKey = folder + "/" + identity + "/" + imageName;
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .contentType("image/webp")
                    .build();
            s3Client.putObject(request, RequestBody.fromBytes(webpBytes));
            log.info("Updated {} for identity: {}, S3 key: {}", imageType, identity, objectKey);
            return objectKey;
        } catch (IOException exception) {
            log.error("Could not convert {} to WebP for identity: {}", imageType, identity, exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not convert " + imageType + " to WebP.", exception);
        } catch (S3Exception exception) {
            log.error(
                    "Could not upload {} for identity: {}. Status: {}, code: {}, message: {}",
                    imageType,
                    identity,
                    exception.statusCode(),
                    exception.awsErrorDetails() == null
                            ? null
                            : exception.awsErrorDetails().errorCode(),
                    exception.awsErrorDetails() == null
                            ? exception.getMessage()
                            : exception.awsErrorDetails().errorMessage(),
                    exception
            );

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not upload " + imageType + " to S3.",
                    exception
            );
        }
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