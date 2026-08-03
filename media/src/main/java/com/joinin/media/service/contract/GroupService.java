package com.joinin.media.service.contract;

import com.joinin.media.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> retrieveGroups(List<String> identities);
}
