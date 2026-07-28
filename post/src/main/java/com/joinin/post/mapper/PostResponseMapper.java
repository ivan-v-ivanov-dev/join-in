package com.joinin.post.mapper;

import com.joinin.post.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostResponseMapper {

    public PostResponse fromPostById(PostByIdEntity entity) {
        return new PostResponse(
                entity.getPostIdentity(),
                entity.getAuthorIdentity(),
                entity.getGroupIdentity(),
                entity.getContent(),
                entity.isHasText(),
                entity.isHasImage(),
                entity.isHasVideo(),
                entity.isPoll(),
                entity.getImageIdentity(),
                entity.getYoutubeUrl(),
                entity.getPollQuestion(),
                mapPollOptions(entity.getPollOptions()),
                entity.getCreatedAt()

        );
    }

    public PostResponse fromPostByAuthor(PostByAuthorEntity entity) {
        return new PostResponse(
                entity.getKey().getPostIdentity(),
                entity.getKey().getAuthorIdentity(),
                entity.getGroupIdentity(),
                entity.getContent(),
                entity.isHasText(),
                entity.isHasImage(),
                entity.isHasVideo(),
                entity.isPoll(),
                entity.getImageIdentity(),
                entity.getYoutubeUrl(),
                entity.getPollQuestion(),
                mapPollOptions(entity.getPollOptions()),
                entity.getKey().getCreatedAt()
        );
    }

    public PostResponse fromPostByGroup(PostByGroupEntity entity) {
        return new PostResponse(
                entity.getKey().getPostIdentity(),
                entity.getAuthorIdentity(),
                entity.getKey().getGroupIdentity(),
                entity.getContent(),
                entity.isHasText(),
                entity.isHasImage(),
                entity.isHasVideo(),
                entity.isPoll(),
                entity.getImageIdentity(),
                entity.getYoutubeUrl(),
                entity.getPollQuestion(),
                mapPollOptions(entity.getPollOptions()),
                entity.getKey().getCreatedAt()
        );
    }

    private List<PollOptionResponse> mapPollOptions(
            List<PollOption> pollOptions
    ) {
        if (pollOptions == null) {
            return List.of();
        }

        return pollOptions.stream()
                .map(this::mapPollOption)
                .toList();
    }

    private PollOptionResponse mapPollOption(PollOption option) {
        return new PollOptionResponse(
                option.getOptionIdentity(),
                option.getOptionText(),
                option.getVoteCount()
        );
    }
}