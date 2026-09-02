package com.joinin.post.mapper;

import com.joinin.post.model.PostByGroupEntity;
import com.joinin.post.model.PostByGroupKey;
import com.joinin.post.model.PostByIdEntity;
import org.springframework.stereotype.Service;

@Service
public class PostByGroupMapper {

    public PostByGroupEntity toEntity(PostByIdEntity postByIdEntity) {

        PostByGroupKey key = PostByGroupKey.builder()
                .groupIdentity(postByIdEntity.getGroupIdentity())
                .createdAt(postByIdEntity.getCreatedAt())
                .postIdentity(postByIdEntity.getPostIdentity())
                .build();

        return PostByGroupEntity.builder()
                .key(key)
                .authorIdentity(postByIdEntity.getAuthorIdentity())
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
