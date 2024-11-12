package com.social.post.adapter.adapter;

import com.social.model.dto.PostRp;
import com.social.post.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiGatewayAdapter {
    PostRp fromPostToPostRp(Post post);
}
