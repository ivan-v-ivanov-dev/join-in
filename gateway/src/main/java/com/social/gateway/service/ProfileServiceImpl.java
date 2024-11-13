package com.social.gateway.service;

import com.social.gateway.adapter.ProfileAdapter;
import com.social.gateway.service.contract.ProfileService;
import com.social.gateway.service.feign.ProfileClient;
import com.social.model.dto.ProfileGatewayRp;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.gateway.service.constants.LoggerConstants.RETRIEVE_PROFILE_NAMES_FROM_PROFILE_SERVICE_TEMPLATE;
import static com.social.gateway.service.constants.LoggerConstants.USER_RETRIEVED_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileClient profileClient;
    private final ProfileAdapter profileAdapter;

    @Override
    public ProfileGatewayRp findProfileInfoByIdentity(String identity) {
        try {
            ProfileGatewayRp profileGatewayRp = profileAdapter.fromProfileRpToProfileGatewayRp(
                    profileClient.findByIdentity(identity));
            log.info(format(USER_RETRIEVED_TEMPLATE, profileGatewayRp.getIdentity()));
            return profileGatewayRp;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }

    @Override
    public String findProfileNames(String authorIdentity) {
        try {
            String names = profileClient.findProfileNames(authorIdentity);
            log.info(format(RETRIEVE_PROFILE_NAMES_FROM_PROFILE_SERVICE_TEMPLATE, authorIdentity));
            return names;
        } catch (FeignException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(exception.getMessage());
        }
    }
}
