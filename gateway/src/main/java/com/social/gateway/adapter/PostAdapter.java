package com.social.gateway.adapter;

import com.social.model.dto.PostGatewayRp;
import com.social.model.dto.PostRp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostAdapter {
    PostGatewayRp fromPostRpToPostGatewayRp(PostRp postRp);
}
