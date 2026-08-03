package com.joinin.mvc.service;

import com.join_in.common_models.GroupRpGatewayService;
import com.joinin.mvc.mappers.GroupMapper;
import com.joinin.mvc.model.Group;
import com.joinin.mvc.service.contract.GroupService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GatewayClient gatewayClient;
    private final GroupMapper groupMapper;

    @Override
    public List<Group> retrieveProfileJoinedGroups(String identity) {
        List<GroupRpGatewayService> groupRpGatewayServices = gatewayClient.retrieveProfileJoinedGroups(identity);
        log.info("Retrieve profile joined group from API gateway. Profile identity: " + identity);
        return groupRpGatewayServices
                .stream()
                .map(groupMapper::fromGroupRpGatewayServicetoGroup)
                .toList();
    }
}
