package com.social.mvc.service;

import com.social.model.dto.PostGatewayRp;
import com.social.mvc.service.contract.PostService;
import com.social.mvc.service.feign.GatewayClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.mvc.service.constants.LoggerConstants.RETRIEVE_POSTS_FOR_USER_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final GatewayClient gatewayClient;

    @Override
    public List<PostGatewayRp> findPostsByAuthorIdentity(String identity) {
        List<PostGatewayRp> posts = gatewayClient.findPostsByAuthorIdentity(identity);
        log.info(format(RETRIEVE_POSTS_FOR_USER_TEMPLATE, identity));
        return posts;
    }
}
