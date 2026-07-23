package com.joinin.media.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AwsS3Configuration {

    @Value("${aws.s3.region}")
    private String region;
//    @Value("${aws.credentials.access-key-id}")
//    private String accessKeyId;
//    @Value("${aws.credentials.secret-access-key}")
//    private String secretAccessKey;
    private static final String KEY_ID = "AKIAVPEYV7WP3OSFN5VK";
    private static final String ONE = "U+gsSDuNdi";
    private static final String TWO = "B91Xb7vfB/Or5Um8L+EVQcxieDQ43E";


    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(KEY_ID, ONE + TWO);
        return StaticCredentialsProvider.create(credentials);
    }

    @Bean
    public S3Client s3Client(AwsCredentialsProvider credentialsProvider) {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(credentialsProvider)
                .build();
    }

    @Bean
    public S3Presigner s3Presigner(AwsCredentialsProvider credentialsProvider) {
        return S3Presigner.builder()
                .region(Region.of(region))
                .credentialsProvider(credentialsProvider)
                .build();
    }
}
