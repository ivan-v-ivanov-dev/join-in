package com.joinin.post.service;

import com.join_in.common_models.*;
import com.joinin.post.mapper.CommentResponseMapper;
import com.joinin.post.mapper.PostResponseMapper;
import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.repository.CommentRepository;
import com.joinin.post.repository.PostByAuthorRepository;
import com.joinin.post.service.contract.PostService;
import com.joinin.post.service.feign.MediaServiceClient;
import com.joinin.post.service.feign.ProfileServiceClient;
import com.joinin.post.service.feign.ReactionServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostByAuthorRepository postByAuthorRepository;
    private final CommentRepository commentRepository;
    private final PostResponseMapper postResponseMapper;
    private final CommentResponseMapper commentResponseMapper;
    private final MediaServiceClient mediaServiceClient;
    private final ProfileServiceClient profileServiceClient;
    private final ReactionServiceClient reactionServiceClient;

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
                    List<CommentEntity> commentEntities = commentRepository.findByPostIdentity(postIdentity);
                    List<String> commentAuthorIdentities = commentEntities.stream().map(CommentEntity::getAuthorIdentity).toList();
                    List<ProfileImageRpMediaService> profileImagesRpMediaServices = mediaServiceClient.retrieveProfileImagesForProfiles(commentAuthorIdentities);
                    List<ProfileRpProfileNamesProfileService> commentProfileNames = profileServiceClient.retrieveProfilesNames(commentAuthorIdentities);
                    List<String> commentIdentities = commentEntities.stream().map(e -> e.getPrimaryKey().getCommentIdentity()).toList();
                    List<CommentReactionsCountRpReactionService> commentReactionsCount = reactionServiceClient.retrieveCommentsReactionsCount(commentIdentities);
                    List<CommentRpPostService> commentRpPostServices = commentEntities
                            .stream()
                            .map(e -> commentResponseMapper.fromCommentEntitytoCommentRpPostService(e, profileImagesRpMediaServices, commentProfileNames, commentReactionsCount))
                            .toList();
                    return postResponseMapper.fromPostByAuthortoPostRpPostService(postEntity, commentRpPostServices, profileImages, profileNames, postReactionsCount);
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
}
