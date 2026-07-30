package com.joinin.reaction.mapper;

import com.join_in.common_models.CommentReactionsCountRpReactionService;
import com.joinin.reaction.model.CommentReactionsCount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentReactionsCountRpReactionService fromCommentReactionsCounttoCommentReactionsCountRpReactionService(CommentReactionsCount comment);
}
