package com.joinin.group.service;

import com.join_in.common_models.GroupRpGroupService;
import com.join_in.common_models.GroupRpImageService;
import com.joinin.group.mapper.GroupsMapper;
import com.joinin.group.model.Group;
import com.joinin.group.repository.GroupRepository;
import com.joinin.group.service.contract.GroupService;
import com.joinin.group.service.feign.MediaServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupsMapper groupsMapper;
    private final MediaServiceClient mediaServiceClient;

    @Override
    public List<GroupRpGroupService> retrieveProfileJoinedGroups(String identity) {
        List<Group> joinedGroups = groupRepository.findAllJoinedGroupsByProfileIdentity(identity);
        log.info("Retrieve profile joined groups. Profile identity: " + identity);

        if (joinedGroups.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> groupIdentities = joinedGroups.stream()
                .map(Group::getIdentity)
                .toList();

        List<GroupRpImageService> groupImages = mediaServiceClient.retrieveGroupsImages(groupIdentities);

        Map<String, String> imagesByGroupIdentity = new HashMap<>();

        if (groupImages != null) {
            groupImages.forEach(groupImage ->
                    imagesByGroupIdentity.put(groupImage.identity(), groupImage.image()));
        }

        return joinedGroups.stream()
                .map(group ->
                        groupsMapper.fromGrouptoGroupRpGroupService(group, imagesByGroupIdentity.get(group.getIdentity())))
                .toList();
    }
}
