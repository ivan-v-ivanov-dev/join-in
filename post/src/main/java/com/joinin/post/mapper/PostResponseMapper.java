package com.joinin.post.mapper;

import com.join_in.common_models.*;
import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.model.PostByAuthorKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostResponseMapper {

    private final PollOptionResponseMapper pollOptionResponseMapper;
    private final PostedAgoFormatter postedAgoFormatter;

    public PostRpPostService fromPostByAuthortoPostRpPostService(PostByAuthorEntity postEntity,
                                                                 String postImage,
                                                                 List<CommentRpPostService> comments,
                                                                 List<ProfileImageRpMediaService> profileImages,
                                                                 List<ProfileRpProfileNamesProfileService> profileNames,
                                                                 List<PostReactionsCountRpReactionService> postReactionsCount) {
        PostByAuthorKey primaryKey = postEntity.getKey();
        String profileImage = profileImages
                .stream()
                .filter(e -> Objects.equals(e.identity(), primaryKey.getAuthorIdentity()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No Image found");
        String names = profileNames
                .stream()
                .filter(e -> Objects.equals(e.identity(), primaryKey.getAuthorIdentity()))
                .map(e -> String.format("%s %s", e.firstName(), e.lastName()))
                .findFirst()
                .orElse("No name found");

        List<PollOptionRpPostService> pollOptions =
                postEntity.getPollOptions() == null
                        ? List.of()
                        : postEntity.getPollOptions()
                        .stream()
                        .map(pollOptionResponseMapper::fromPollOptiontoPollOptionRpPostService)
                        .toList();

        int likeCount = postReactionsCount
                .stream()
                .filter(e -> e.identity().equals(primaryKey.getPostIdentity()))
                .map(PostReactionsCountRpReactionService::likeCount)
                .findFirst()
                .orElse(0);

        int dislikeCount = postReactionsCount
                .stream()
                .filter(e -> e.identity().equals(primaryKey.getPostIdentity()))
                .map(PostReactionsCountRpReactionService::dislikeCount)
                .findFirst()
                .orElse(0);

        int hahaCount = postReactionsCount
                .stream()
                .filter(e -> e.identity().equals(primaryKey.getPostIdentity()))
                .map(PostReactionsCountRpReactionService::hahaCount)
                .findFirst()
                .orElse(0);

        int angryCount = postReactionsCount
                .stream()
                .filter(e -> e.identity().equals(primaryKey.getPostIdentity()))
                .map(PostReactionsCountRpReactionService::angryCount)
                .findFirst()
                .orElse(0);

        return new PostRpPostService(
                profileImage,
                names,

                primaryKey.getPostIdentity(),
                primaryKey.getAuthorIdentity(),
                postEntity.getGroupIdentity(),

                postEntity.getContent(),

                postEntity.isHasText(),
                postEntity.isHasImage(),
                postEntity.isHasVideo(),
                postEntity.isPoll(),

                postImage,
                postEntity.getYoutubeUrl(),

                postEntity.getPollQuestion(),
                pollOptions,

                likeCount,
                dislikeCount,
                hahaCount,
                angryCount,

                postedAgoFormatter.calculatePostedAgo(primaryKey.getCreatedAt()),

                comments
        );
    }
}