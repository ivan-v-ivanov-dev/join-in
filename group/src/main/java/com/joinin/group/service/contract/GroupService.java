package com.joinin.group.service.contract;

import com.join_in.common_models.GroupRpGroupService;

import java.util.List;

public interface GroupService {
    List<GroupRpGroupService> retrieveProfileJoinedGroups(String identity);

    List<GroupRpGroupService> retrieveProfileSuggestedGroups(String identity);
}
