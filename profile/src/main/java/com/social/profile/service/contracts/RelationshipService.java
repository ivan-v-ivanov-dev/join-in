package com.social.profile.service.contracts;

import com.social.profile.model.dto.FriendsDto;

import java.util.List;

public interface RelationshipService {
    List<FriendsDto> findFriends(String identity);
}
