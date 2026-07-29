package com.joinin.post.mapper;

import com.join_in.common_models.CommentRpPostService;
import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.CommentPrimaryKey;
import com.joinin.post.model.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentResponseMapper {

    private final PostedAgoFormatter postedAgoFormatter;

    public CommentRpPostService fromCommentEntitytoCommentRpPostService(CommentEntity commentEntity) {
        CommentPrimaryKey primaryKey = commentEntity.getPrimaryKey();

        return new CommentRpPostService(
                primaryKey.getCommentIdentity(),
                primaryKey.getPostIdentity(),
                commentEntity.getAuthorIdentity(),
                commentEntity.getContent(),
                postedAgoFormatter.calculatePostedAgo(commentEntity.getPrimaryKey().getCreatedAt())
        );
    }
}
