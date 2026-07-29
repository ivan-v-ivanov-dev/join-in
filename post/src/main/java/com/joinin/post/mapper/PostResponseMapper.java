package com.joinin.post.mapper;

import com.joinin.post.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostResponseMapper {

    private final PollOptionResponseMapper pollOptionResponseMapper;
    private final PostedAgoFormatter postedAgoFormatter;

    public PostResponse fromPostByAuthor(PostByAuthorEntity postEntity, List<CommentResponse> comments) {
        PostByAuthorKey primaryKey = postEntity.getKey();

        List<PollOptionResponse> pollOptions =
                postEntity.getPollOptions() == null
                        ? List.of()
                        : postEntity.getPollOptions()
                        .stream()
                        .map(pollOptionResponseMapper::fromPollOption)
                        .toList();

        return new PostResponse(
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