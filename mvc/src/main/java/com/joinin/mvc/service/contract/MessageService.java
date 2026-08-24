package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Conversation;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface MessageService {
    List<Conversation> retrieveConversations(String identity);

    String retrieveProfileOnlineStatus(String identity);
}
