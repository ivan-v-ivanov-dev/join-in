package com.social.mvc.service;

import com.social.model.dto.ProfileGatewayRp;
import com.social.mvc.service.contract.ProfileService;
import com.social.mvc.service.feign.GatewayClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.mvc.service.constants.LoggerConstants.PROFILE_INFORMATION_RETRIEVED_FOR_USER_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final GatewayClient gatewayClient;

    @Override
    public ProfileGatewayRp findProfileInfoByIdentity(String identity) {
        try {
            ProfileGatewayRp profile = gatewayClient.findProfileInfoByIdentity(identity);
            log.info(format(PROFILE_INFORMATION_RETRIEVED_FOR_USER_TEMPLATE, identity));
            return profile;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(feignException.getMessage());
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }
}
