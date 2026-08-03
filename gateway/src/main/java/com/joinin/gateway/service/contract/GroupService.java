package com.joinin.gateway.service.contract;

import com.join_in.common_models.GroupRpGatewayService;

import java.util.List;

public interface GroupService {
    List<GroupRpGatewayService> retrieveProfileJoinedGroups(String identity);
}
