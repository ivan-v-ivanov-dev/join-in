package com.joinin.group.controller;

import com.join_in.common_models.GroupRpGroupService;
import com.joinin.group.service.contract.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/profile/{identity}/joined-groups")
    public List<GroupRpGroupService> retrieveProfileJoinedGroups(@PathVariable("identity") String identity) {
        return groupService.retrieveProfileJoinedGroups(identity);
    }

    @GetMapping("/profile/{identity}/suggested-groups")
    public List<GroupRpGroupService> retrieveSuggestedGroups(@PathVariable("identity") String identity) {
        return groupService.retrieveProfileSuggestedGroups(identity);
    }
}
