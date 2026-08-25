package com.joinin.post.mapper;

import com.join_in.common_models.*;
import com.joinin.post.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostResponseMapper {

    private final PollOptionResponseMapper pollOptionResponseMapper;
    private final PostedAgoFormatter postedAgoFormatter;

    public PostRpPostService fromPostByAuthortoPostRpPostService(
            PostByAuthorEntity postEntity,
            String postImage,
            List<CommentRpPostService> comments,
            List<ProfileImageRpMediaService> profileImages,
            List<ProfileRpProfileNamesProfileService> profileNames,
            List<PostReactionsCountRpReactionService> postReactionsCount) {

        PostByAuthorKey primaryKey = postEntity.getKey();

        return mapToPostResponse(
                primaryKey.getPostIdentity(),
                primaryKey.getAuthorIdentity(),
                primaryKey.getCreatedAt(),
                postEntity.getGroupIdentity(),
                postEntity.getContent(),
                postEntity.isHasText(),
                postEntity.isHasImage(),
                postEntity.isHasVideo(),
                postEntity.isPoll(),
                postEntity.getYoutubeUrl(),
                postEntity.getPollQuestion(),
                postEntity.getPollOptions(),
                postImage,
                comments,
                profileImages,
                profileNames,
                postReactionsCount
        );
    }

    public PostRpPostService fromFeedUserEntityToPostRpPostService(
            FeedUserEntity postEntity,
            String postImage,
            List<CommentRpPostService> comments,
            List<ProfileImageRpMediaService> profileImages,
            List<ProfileRpProfileNamesProfileService> profileNames,
            List<PostReactionsCountRpReactionService> postReactionsCount) {

        FeedUserPrimaryKey primaryKey = postEntity.getPrimaryKey();

        return mapToPostResponse(
                primaryKey.getPostIdentity(),
                postEntity.getAuthorIdentity(),
                primaryKey.getCreatedAt(),
                postEntity.getGroupIdentity(),
                postEntity.getContent(),
                Boolean.TRUE.equals(postEntity.getHasText()),
                Boolean.TRUE.equals(postEntity.getHasImage()),
                Boolean.TRUE.equals(postEntity.getHasVideo()),
                Boolean.TRUE.equals(postEntity.getPoll()),
                postEntity.getYoutubeUrl(),
                postEntity.getPollQuestion(),
                postEntity.getPollOptions(),
                postImage,
                comments,
                profileImages,
                profileNames,
                postReactionsCount
        );
    }

    private PostRpPostService mapToPostResponse(
            String postIdentity,
            String authorIdentity,
            LocalDateTime createdAt,
            String groupIdentity,
            String content,
            boolean hasText,
            boolean hasImage,
            boolean hasVideo,
            boolean poll,
            String youtubeUrl,
            String pollQuestion,
            List<PollOption> pollOptions,
            String postImage,
            List<CommentRpPostService> comments,
            List<ProfileImageRpMediaService> profileImages,
            List<ProfileRpProfileNamesProfileService> profileNames,
            List<PostReactionsCountRpReactionService> postReactionsCount) {

        String profileImage = findProfileImage(
                authorIdentity,
                profileImages
        );

        String names = findProfileNames(
                authorIdentity,
                profileNames
        );

        List<PollOptionRpPostService> pollOptionResponses =
                mapPollOptions(pollOptions);

        PostReactionsCountRpReactionService reactions =
                findPostReactions(
                        postIdentity,
                        postReactionsCount
                );

        return new PostRpPostService(
                profileImage,
                names,

                postIdentity,
                authorIdentity,
                groupIdentity,

                content,

                hasText,
                hasImage,
                hasVideo,
                poll,

                postImage,
                youtubeUrl,

                pollQuestion,
                pollOptionResponses,

                reactions != null ? reactions.likeCount() : 0,
                reactions != null ? reactions.dislikeCount() : 0,
                reactions != null ? reactions.hahaCount() : 0,
                reactions != null ? reactions.angryCount() : 0,

                postedAgoFormatter.calculatePostedAgo(createdAt),

                comments
        );
    }

    private String findProfileImage(
            String authorIdentity,
            List<ProfileImageRpMediaService> profileImages) {

        return profileImages
                .stream()
                .filter(e -> Objects.equals(
                        e.identity(),
                        authorIdentity
                ))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No Image found");
    }

    private String findProfileNames(
            String authorIdentity,
            List<ProfileRpProfileNamesProfileService> profileNames) {

        return profileNames
                .stream()
                .filter(e -> Objects.equals(
                        e.identity(),
                        authorIdentity
                ))
                .map(e -> String.format(
                        "%s %s",
                        e.firstName(),
                        e.lastName()
                ))
                .findFirst()
                .orElse("No name found");
    }

    private List<PollOptionRpPostService> mapPollOptions(
            List<PollOption> pollOptions) {

        if (pollOptions == null) {
            return List.of();
        }

        return pollOptions
                .stream()
                .map(
                        pollOptionResponseMapper
                                ::fromPollOptiontoPollOptionRpPostService
                )
                .toList();
    }

    private PostReactionsCountRpReactionService findPostReactions(
            String postIdentity,
            List<PostReactionsCountRpReactionService> postReactionsCount) {

        return postReactionsCount
                .stream()
                .filter(e -> Objects.equals(
                        e.identity(),
                        postIdentity
                ))
                .findFirst()
                .orElse(null);
    }
}