package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> retrieveProfileJoinedGroups(String identity);
}
