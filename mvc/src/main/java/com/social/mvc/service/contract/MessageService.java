package com.social.mvc.service.contract;

import com.social.model.dto.FriendGatewayRp;

import java.util.List;

public interface MessageService {
    List<FriendGatewayRp> findProfileOnlineFriends(String identity);
}