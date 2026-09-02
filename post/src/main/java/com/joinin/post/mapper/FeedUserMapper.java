package com.joinin.post.mapper;

import com.joinin.post.model.FeedUserEntity;
import com.joinin.post.model.FeedUserPrimaryKey;
import com.joinin.post.model.PostByIdEntity;
import org.springframework.stereotype.Service;

@Service
public class FeedUserMapper {

    public FeedUserEntity toEntity(PostByIdEntity postByIdEntity, String userIdentity) {

        FeedUserPrimaryKey primaryKey = FeedUserPrimaryKey.builder()
                .userIdentity(userIdentity)
                .createdAt(postByIdEntity.getCreatedAt())
                .postIdentity(postByIdEntity.getPostIdentity())
                .build();

        return FeedUserEntity.builder()
                .primaryKey(primaryKey)
                .authorIdentity(postByIdEntity.getAuthorIdentity())
                .groupIdentity(postByIdEntity.getGroupIdentity())
                .content(postByIdEntity.getContent())
                .hasText(postByIdEntity.isHasText())
                .hasImage(postByIdEntity.isHasImage())
                .hasVideo(postByIdEntity.isHasVideo())
                .poll(postByIdEntity.isPoll())
                .imageIdentity(postByIdEntity.getImageIdentity())
                .youtubeUrl(postByIdEntity.getYoutubeUrl())
                .pollQuestion(postByIdEntity.getPollQuestion())
                .pollOptions(postByIdEntity.getPollOptions())
                .build();
    }
}
