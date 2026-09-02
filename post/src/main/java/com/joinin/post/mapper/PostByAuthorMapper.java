package com.joinin.post.mapper;

import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.model.PostByAuthorKey;
import com.joinin.post.model.PostByIdEntity;
import org.springframework.stereotype.Service;

@Service
public class PostByAuthorMapper {

    public PostByAuthorEntity toEntity(PostByIdEntity postByIdEntity) {

        PostByAuthorKey key = PostByAuthorKey.builder()
                .authorIdentity(postByIdEntity.getAuthorIdentity())
                .createdAt(postByIdEntity.getCreatedAt())
                .postIdentity(postByIdEntity.getPostIdentity())
                .build();

        return PostByAuthorEntity.builder()
                .key(key)
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
