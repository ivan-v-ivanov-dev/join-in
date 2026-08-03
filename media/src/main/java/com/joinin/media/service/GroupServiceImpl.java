package com.joinin.media.service;

import com.joinin.media.model.Group;
import com.joinin.media.repository.GroupRepository;
import com.joinin.media.service.contract.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> retrieveGroups(List<String> identities) {
        List<Group> groups = groupRepository.findAllByIdentities(identities);
        log.info("Retrieve groups from database: " + String.join(", ", identities));
        return groups;
    }
}
