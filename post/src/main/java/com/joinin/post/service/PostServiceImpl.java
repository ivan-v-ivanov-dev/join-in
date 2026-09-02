package com.joinin.post.service;

import com.join_in.common_models.*;
import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.PostImage;
import com.joinin.post.mapper.*;
import com.joinin.post.model.*;
import com.joinin.post.repository.*;
import com.joinin.post.service.contract.PostService;
import com.joinin.post.service.feign.MediaServiceClient;
import com.joinin.post.service.feign.ProfileServiceClient;
import com.joinin.post.service.feign.ReactionServiceClient;
import com.joinin.post.service.feign.RelationshipServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostByAuthorRepository postByAuthorRepository;
    private final CommentByPostRepository commentByPostRepository;
    private final FeedUserRepository feedUserRepository;
    private final PostByIdRepository postByIdRepository;
    private final PostByGroupRepository postByGroupRepository;
    private final MediaServiceClient mediaServiceClient;
    private final ProfileServiceClient profileServiceClient;
    private final ReactionServiceClient reactionServiceClient;
    private final RelationshipServiceClient relationshipServiceClient;
    private final PostResponseMapper postResponseMapper;
    private final CommentResponseMapper commentResponseMapper;
    private final PostByIdMapper postByIdMapper;
    private final PostByAuthorMapper postByAuthorMapper;
    private final PostByGroupMapper postByGroupMapper;
    private final FeedUserMapper feedUserMapper;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.post-an-image}")
    private String postAnImageTopic;

    @Override
    public List<PostRpPostService> retrievePostsByAuthor(String identity) {
        List<PostByAuthorEntity> postEntities = postByAuthorRepository.findAllByAuthorIdentity(identity);
        log.info("Retrieve posts by author identity: " + identity);
        List<ProfileImageRpMediaService> profileImages = mediaServiceClient.retrieveProfileImagesForProfiles(List.of(identity));
        List<ProfileRpProfileNamesProfileService> profileNames = profileServiceClient.retrieveProfilesNames(List.of(identity));
        List<String> postsIdentities = postEntities.stream().map(e -> e.getKey().getPostIdentity()).toList();
        List<PostReactionsCountRpReactionService> postReactionsCount = reactionServiceClient.retrievePostReactionsCount(postsIdentities);

        List<PostRpPostService> posts = postEntities.stream()
                .map(postEntity -> {
                    String postIdentity = postEntity.getKey().getPostIdentity();
                    String postImage = null;
                    if (postEntity.isHasImage()) {
                        postImage = mediaServiceClient.retrievePostImage(postIdentity);
                    }
                    List<CommentByPostEntity> commentEntities = commentByPostRepository.findByPostIdentity(postIdentity);
                    List<String> commentAuthorIdentities = commentEntities.stream().map(CommentByPostEntity::getAuthorIdentity).toList();
                    List<ProfileImageRpMediaService> profileImagesRpMediaServices = mediaServiceClient.retrieveProfileImagesForProfiles(commentAuthorIdentities);
                    List<ProfileRpProfileNamesProfileService> commentProfileNames = profileServiceClient.retrieveProfilesNames(commentAuthorIdentities);
                    List<String> commentIdentities = commentEntities.stream().map(e -> e.getPrimaryKey().getCommentIdentity()).toList();
                    List<CommentReactionsCountRpReactionService> commentReactionsCount = reactionServiceClient.retrieveCommentsReactionsCount(commentIdentities);
                    List<CommentRpPostService> commentRpPostServices = commentEntities
                            .stream()
                            .map(e -> commentResponseMapper.fromCommentEntitytoCommentRpPostService(e, profileImagesRpMediaServices, commentProfileNames, commentReactionsCount))
                            .toList();
                    return postResponseMapper.fromPostByAuthortoPostRpPostService(postEntity, postImage, commentRpPostServices, profileImages, profileNames, postReactionsCount);
                })
                .toList();
        log.info("Retrieve comments for all posts");
        return posts;
    }

    @Override
    public List<PostRpPostService> retrieveProfileFeedPosts(String identity) {
        List<FeedUserEntity> feedPosts = feedUserRepository.findFeedByUserIdentity(identity);
        log.info("Retrieve user's feed posts by profile identity: " + identity);
        List<String> authorIdentities = feedPosts.stream().map(FeedUserEntity::getAuthorIdentity).toList();
        List<ProfileImageRpMediaService> profileImages = mediaServiceClient.retrieveProfileImagesForProfiles(authorIdentities);
        List<ProfileRpProfileNamesProfileService> profileNames = profileServiceClient.retrieveProfilesNames(authorIdentities);
        List<String> postIdentities = feedPosts.stream().map(e -> e.getPrimaryKey().getPostIdentity()).toList();
        List<PostReactionsCountRpReactionService> postReactionsCount = reactionServiceClient.retrievePostReactionsCount(postIdentities);

        List<PostRpPostService> posts = feedPosts
                .stream()
                .map(postEntity -> {
                    String postIdentity = postEntity.getPrimaryKey().getPostIdentity();
                    String postImage = null;
                    if (postEntity.getHasImage()) {
                        postImage = mediaServiceClient.retrievePostImage(postIdentity);
                    }

                    List<CommentByPostEntity> commentEntities = commentByPostRepository.findByPostIdentity(postIdentity);
                    List<String> commentAuthorIdentities = commentEntities.stream().map(CommentByPostEntity::getAuthorIdentity).toList();
                    List<ProfileImageRpMediaService> profileImagesRpMediaServices = mediaServiceClient.retrieveProfileImagesForProfiles(commentAuthorIdentities);
                    List<ProfileRpProfileNamesProfileService> commentProfileNames = profileServiceClient.retrieveProfilesNames(commentAuthorIdentities);
                    List<String> commentIdentities = commentEntities.stream().map(e -> e.getPrimaryKey().getCommentIdentity()).toList();
                    List<CommentReactionsCountRpReactionService> commentReactionsCount = reactionServiceClient.retrieveCommentsReactionsCount(commentIdentities);
                    List<CommentRpPostService> commentRpPostServices = commentEntities
                            .stream()
                            .map(e -> commentResponseMapper.fromCommentEntitytoCommentRpPostService(e, profileImagesRpMediaServices, commentProfileNames, commentReactionsCount))
                            .toList();
                    return postResponseMapper.fromFeedUserEntityToPostRpPostService(postEntity, postImage, commentRpPostServices, profileImages, profileNames, postReactionsCount);
                })
                .toList();
        log.info("Retrieve comments for all posts");
        return posts;
    }

    @Override
    public int retrieveProfilePostsCount(String identity) {
        int postsCount = postByAuthorRepository.retrieveProfilePostsCount(identity);
        log.info("Retrieve post count for profile: " + identity);
        return postsCount;
    }

    @Override
    public List<String> retrievePostIdentitiesByAuthor(String identity) {
        List<PostByAuthorEntity> postsByAuthor = postByAuthorRepository.findAllByAuthorIdentity(identity);
        log.info("Retrieve all post identities for profile: " + identity);
        return postsByAuthor
                .stream()
                .map(e -> e.getKey().getPostIdentity())
                .toList();
    }

    @Override
    public void postAPost(String profileIdentity, String groupIdentity, String content, byte[] imageBytes, String youtubeUrl, String pollQuestion, List<String> pollOptions) {
        // create posts_by_identity
        PostByIdEntity postByIdEntity = postByIdMapper.toEntity(profileIdentity, groupIdentity, content,
                imageBytes, youtubeUrl, pollQuestion, pollOptions);
        postByIdRepository.save(postByIdEntity);
        log.info("Post saved in posts_by_identity table. Post identity: " + postByIdEntity.getPostIdentity());

        // if has Image send to media service
        if (imageBytes != null && imageBytes.length != 0) {
            KafkaMessage postImageMessage = new PostImage(postByIdEntity.getPostIdentity(), postByIdEntity.getImageIdentity(), imageBytes);
            kafkaTemplate.send(postAnImageTopic, postImageMessage);
            log.info("Image sent to Media service. Image identity: " + postByIdEntity.getImageIdentity());
        }

        // create posts_by_author
        PostByAuthorEntity postByAuthorEntity = postByAuthorMapper.toEntity(postByIdEntity);
        postByAuthorRepository.save(postByAuthorEntity);
        log.info("Post saved in posts_by_author table. Post identity: " + postByIdEntity.getPostIdentity());

        // create posts_by_group
        if (groupIdentity != null && !groupIdentity.isBlank()) {
            PostByGroupEntity postByGroupEntity = postByGroupMapper.toEntity(postByIdEntity);
            postByGroupRepository.save(postByGroupEntity);
            log.info("Post saved in posts_by_group table. Post identity: " + postByIdEntity.getPostIdentity());
        }

        // create feed_by_user (extract all friends for this table)
        List<String> friendsIdentities = relationshipServiceClient.retrieveFriendsIdentities(postByIdEntity.getAuthorIdentity());
        if (!friendsIdentities.isEmpty()) {
            List<FeedUserEntity> feedByUserPosts = friendsIdentities.stream()
                    .map(userIdentity -> feedUserMapper.toEntity(postByIdEntity, userIdentity))
                    .toList();
            feedUserRepository.saveAll(feedByUserPosts);
            log.info("Posts saved in feed_by_user table. Post identity: " + postByIdEntity.getPostIdentity());
        }
    }
}
