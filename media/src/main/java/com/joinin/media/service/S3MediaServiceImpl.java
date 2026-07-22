package com.joinin.media.service;

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

@Service
@RequiredArgsConstructor
@Slf4j
public class S3MediaServiceImpl implements S3MediaService {

    private final S3Client s3Client;
    private final ProfileService profileService;
    @Value("${aws.s3.bucket}")
    private String bucket;

    @Override
    public byte[] getProfilePicture(String identity) {
        Profile profile = profileService.getProfileByIdentity(identity);

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucket)
                .key(profile.getProfilePictureUrl())
                .build();

        try {
            byte[] profilePictureArray = s3Client.getObjectAsBytes(request).asByteArray();
            log.info("Retrieve profile picture for profile: " + profile.getIdentity());
            return profilePictureArray;
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
}
