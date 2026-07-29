package com.joinin.gateway.mapper;

import com.join_in.common_models.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostRpGatewayService fromPostRpPostServicetoPostRpGatewayService(PostRpPostService post);

    PollOptionRpGatewayService fromPollOptionRpPostServicetoPollOptionRpGatewayService(PollOptionRpPostService pollOption);

    CommentRpGatewayService fromCommentRpPostServicetoCommentRpGatewayService(CommentRpPostService comment);
}
