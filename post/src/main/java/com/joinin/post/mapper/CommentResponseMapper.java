package com.joinin.post.mapper;

import com.join_in.common_models.CommentRpPostService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.CommentPrimaryKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentResponseMapper {

    private final PostedAgoFormatter postedAgoFormatter;

    public CommentRpPostService fromCommentEntitytoCommentRpPostService(CommentEntity commentEntity, List<ProfileImageRpMediaService> profileImagesRpMediaServices) {
        CommentPrimaryKey primaryKey = commentEntity.getPrimaryKey();

        String image = profileImagesRpMediaServices
                .stream()
                .filter(e -> Objects.equals(e.identity(), commentEntity.getAuthorIdentity()))
                .findFirst().get()
                .profileImage();

        return new CommentRpPostService(
                image,
                //TODO Add profile name
                "Ivan",
                primaryKey.getCommentIdentity(),
                primaryKey.getPostIdentity(),
                commentEntity.getAuthorIdentity(),
                commentEntity.getContent(),
                postedAgoFormatter.calculatePostedAgo(commentEntity.getPrimaryKey().getCreatedAt())
        );
    }
}
