package com.joinin.post.mapper;

import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.CommentPrimaryKey;
import com.joinin.post.model.CommentResponse;
import org.springframework.stereotype.Service;

@Service
public class CommentResponseMapper {

    public CommentResponse fromCommentEntity(CommentEntity commentEntity) {
        CommentPrimaryKey primaryKey = commentEntity.getPrimaryKey();

        return new CommentResponse(
                primaryKey.getCommentIdentity(),
                primaryKey.getPostIdentity(),
                commentEntity.getAuthorIdentity(),
                commentEntity.getContent(),
                primaryKey.getCreatedAt()
        );
    }
}
