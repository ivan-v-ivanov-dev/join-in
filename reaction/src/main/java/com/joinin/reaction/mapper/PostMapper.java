package com.joinin.reaction.mapper;

import com.join_in.common_models.PostReactionsCountRpReactionService;
import com.joinin.reaction.model.PostReactionsCount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostReactionsCountRpReactionService fromPostReactionsCounttoPostReactionsCountRpReactionService(PostReactionsCount postReactionsCount);
}
