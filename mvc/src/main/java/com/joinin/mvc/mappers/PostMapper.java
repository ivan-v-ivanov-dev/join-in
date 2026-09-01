package com.joinin.mvc.mappers;

import com.join_in.common_models.*;
import com.joinin.mvc.model.Comment;
import com.joinin.mvc.model.PollOption;
import com.joinin.mvc.model.Post;
import com.joinin.mvc.model.PostRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post fromPostRpGatewayServicetoPost(PostRpGatewayService post);

    PollOption fromPollOptionRpGatewayServicetoPollOption(PollOptionRpGatewayService pollOption);

    Comment fromCommentRpGatewayServicetoComment(CommentRpGatewayService comment);

    @Mapping(target = "imageBytes", source = "image", qualifiedByName = "multipartFileToBytes")
    PostGatewayRq fromPostRqToPostGatewayRq(PostRq postRq);

    @Named("multipartFileToBytes")
    default byte[] multipartFileToBytes(MultipartFile image) {

        if (image == null || image.isEmpty()) {
            return null;
        }

        try {
            return image.getBytes();
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Could not read uploaded image.",
                    e
            );
        }
    }
}
