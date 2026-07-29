package com.joinin.mvc.mappers;

import com.join_in.common_models.*;
import com.joinin.mvc.model.Comment;
import com.joinin.mvc.model.PollOption;
import com.joinin.mvc.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post fromPostRpGatewayServicetoPost(PostRpGatewayService post);

    PollOption fromPollOptionRpGatewayServicetoPollOption(PollOptionRpGatewayService pollOption);

    Comment fromCommentRpGatewayServicetoComment(CommentRpGatewayService comment);
}
