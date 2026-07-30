package com.joinin.post.mapper;

import com.join_in.common_models.CommentRpPostService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
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

    public CommentRpPostService fromCommentEntitytoCommentRpPostService(CommentEntity commentEntity,
                                                                        List<ProfileImageRpMediaService> profileImagesRpMediaServices,
                                                                        List<ProfileRpProfileNamesProfileService> commentProfileNames) {
        CommentPrimaryKey primaryKey = commentEntity.getPrimaryKey();

        String image = profileImagesRpMediaServices.stream()
                .filter(e -> Objects.equals(e.identity(), commentEntity.getAuthorIdentity()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No Image found");
        String names = commentProfileNames
                .stream()
                .filter(e -> Objects.equals(e.identity(), commentEntity.getAuthorIdentity()))
                .map(e -> String.format("%s %s", e.firstName(), e.lastName()))
                .findFirst()
                .orElse("No name found");

        return new CommentRpPostService(
                image,
                names,
                primaryKey.getCommentIdentity(),
                primaryKey.getPostIdentity(),
                commentEntity.getAuthorIdentity(),
                commentEntity.getContent(),
                postedAgoFormatter.calculatePostedAgo(commentEntity.getPrimaryKey().getCreatedAt())
        );
    }
}
