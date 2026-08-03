package com.joinin.group.service;

import com.join_in.common_models.GroupRpGroupService;
import com.joinin.group.mapper.GroupsMapper;
import com.joinin.group.model.Group;
import com.joinin.group.repository.GroupRepository;
import com.joinin.group.service.contract.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupsMapper groupsMapper;

    @Override
    public List<GroupRpGroupService> retrieveProfileJoinedGroups(String identity) {
        List<Group> joinedGroups = groupRepository.findAllJoinedGroupsByProfileIdentity(identity);
        log.info("Retrieve profile joined groups. Profile identity: " + identity);
        return joinedGroups
                .stream()
                .map(groupsMapper::fromGrouptoGroupRpGroupService)
                .toList();
    }
}
