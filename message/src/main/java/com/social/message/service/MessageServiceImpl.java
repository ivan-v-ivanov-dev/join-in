package com.social.message.service;

import com.social.message.repository.contract.MessageRepository;
import com.social.message.service.contracts.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.message.service.constants.LoggerConstants.SET_USER_OFFLINE_TEMPLATE;
import static com.social.message.service.constants.LoggerConstants.SET_USER_ONLINE_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void userIsOnline(String identity) {
        messageRepository.userIsOnline(identity);
        log.info(String.format(SET_USER_ONLINE_TEMPLATE, identity));
    }

    @Override
    public void userIsOffline(String identity) {
        messageRepository.userIsOffline(identity);
        log.info(String.format(SET_USER_OFFLINE_TEMPLATE, identity));
    }
}
