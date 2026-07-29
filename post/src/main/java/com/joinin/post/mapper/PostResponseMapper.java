package com.joinin.post.mapper;

import com.join_in.common_models.CommentRpPostService;
import com.join_in.common_models.PollOptionRpPostService;
import com.join_in.common_models.PostRpPostService;
import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.model.PostByAuthorKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostResponseMapper {

    private final PollOptionResponseMapper pollOptionResponseMapper;
    private final PostedAgoFormatter postedAgoFormatter;

    public PostRpPostService fromPostByAuthortoPostRpPostService(PostByAuthorEntity postEntity, List<CommentRpPostService> comments) {
        PostByAuthorKey primaryKey = postEntity.getKey();

        List<PollOptionRpPostService> pollOptions =
                postEntity.getPollOptions() == null
                        ? List.of()
                        : postEntity.getPollOptions()
                        .stream()
                        .map(pollOptionResponseMapper::fromPollOptiontoPollOptionRpPostService)
                        .toList();

        return new PostRpPostService(
                primaryKey.getPostIdentity(),
                primaryKey.getAuthorIdentity(),
                postEntity.getGroupIdentity(),

                postEntity.getContent(),

                postEntity.isHasText(),
                postEntity.isHasImage(),
                postEntity.isHasVideo(),
                postEntity.isPoll(),

                postEntity.getImageIdentity(),
                postEntity.getYoutubeUrl(),

                postEntity.getPollQuestion(),
                pollOptions,

                postedAgoFormatter.calculatePostedAgo(primaryKey.getCreatedAt()),

                comments
        );
    }
}