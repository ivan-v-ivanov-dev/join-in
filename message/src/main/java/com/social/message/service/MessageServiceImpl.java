package com.social.message.service;

import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import com.social.message.service.contracts.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.social.message.service.constants.LoggerConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void userIsOnline(String identity) {
        messageRepository.userIsOnline(identity);
        log.info(format(SET_USER_ONLINE_TEMPLATE, identity));
    }

    @Override
    public void userIsOffline(String identity) {
        messageRepository.userIsOffline(identity);
        log.info(format(SET_USER_OFFLINE_TEMPLATE, identity));
    }

    @Override
    public boolean findUserOnlineStatus(String identity) {
        boolean onlineStatus = messageRepository.findUserOnlineStatus(identity);
        log.info(format(RETRIEVE_USER_ONLINE_STATUS_TEMPLATE, identity));
        return onlineStatus;
    }
}
