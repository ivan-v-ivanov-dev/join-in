package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Group;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface GroupService {
    List<Group> retrieveProfileJoinedGroups(String identity);

    List<Group> retrieveProfileSuggestedGroups(String identity);
}
