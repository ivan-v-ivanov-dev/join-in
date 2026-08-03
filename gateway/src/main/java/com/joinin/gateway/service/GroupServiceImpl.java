package com.joinin.gateway.service;

import com.join_in.common_models.GroupRpGatewayService;
import com.join_in.common_models.GroupRpGroupService;
import com.joinin.gateway.mapper.GroupMapper;
import com.joinin.gateway.service.contract.GroupService;
import com.joinin.gateway.service.feign.GroupServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupServiceClient groupServiceClient;
    private final GroupMapper groupMapper;

    @Override
    public List<GroupRpGatewayService> retrieveProfileJoinedGroups(String identity) {
        List<GroupRpGroupService> groupRpGroupServices = groupServiceClient.retrieveProfileJoinedGroups(identity);
        log.info("Retrieve joined groups from Group Service for Profile: " + identity);
        if (groupRpGroupServices.isEmpty()) {
            return new ArrayList<>();
        }

        return groupRpGroupServices
                .stream()
                .map(groupMapper::fromGroupRpGroupServicetoGroupRpGatewayService)
                .toList();

    }
}
