package com.social.relationship.service;

import com.social.relationship.model.Friend;
import com.social.relationship.model.FriendSuggestion;
import com.social.relationship.model.FriendshipRequest;
import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.feign.ImageClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @Mock
    ProfileRepository profileRepository;
    @Mock
    ImageClient imageClient;
    @InjectMocks
    ProfileServiceImpl profileService;

    @Test
    public void findFriendsByProfileIdentity_should_returnFriendIdentities() {
        Set<String> friendIdentities = Set.of("identity");
        when(profileRepository.findFriendsByProfileIdentity("identity")).thenReturn(friendIdentities);
        when(imageClient.findProfileImage("identity")).thenReturn("identity");

        assertEquals(friendIdentities.toArray()[0],
                ((Friend) profileService.findFriendsByProfileIdentity("identity").toArray()[0]).getProfileIdentity());
    }

    @Test
    public void findFriendsByProfileIdentity_should_throwException() {
        when(profileRepository.findFriendsByProfileIdentity("identity")).thenReturn(Set.of("identity"));
        when(imageClient.findProfileImage("identity")).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> profileService.findFriendsByProfileIdentity("identity"));
    }

    @Test
    public void save_should_callRepository() {
        Profile profile = Profile.builder().identity("identity").build();
        profileService.save(profile);

        verify(profileRepository, times(1)).save(profile);
    }

    @Test
    public void findFriendCountByProfileIdentity_should_returnFriendCount() {
        when(profileRepository.findFriendCountByProfileIdentity("identity")).thenReturn(1);

        assertEquals(1, profileService.findFriendCountByProfileIdentity("identity"));
    }

    @Test
    public void findFriendshipRequest_should_returnFriendshipRequest() {
        Set<String> friendIdentities = Set.of("identity");
        when(profileRepository.findFriendshipRequestByProfileIdentity("identity")).thenReturn(friendIdentities);
        when(imageClient.findProfileImage("identity")).thenReturn("identity");
        when(profileRepository.findFriendCountByProfileIdentity("identity")).thenReturn(1);

        List<FriendshipRequest> expected = List.of(FriendshipRequest.builder()
                .profileIdentity("identity")
                .profileImage("image")
                .friendsCount(1)
                .build());

        assertEquals(expected.get(0).getProfileIdentity(),
                ((FriendshipRequest) profileService.findFriendshipRequest("identity").toArray()[0]).getProfileIdentity());
    }

    @Test
    public void findFriendshipRequest_should_throwException() {
        when(profileRepository.findFriendshipRequestByProfileIdentity("identity")).thenReturn(Set.of("identity"));
        when(imageClient.findProfileImage("identity")).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> profileService.findFriendshipRequest("identity"));
    }

    @Test
    public void findFriendshipRequestCountByProfileIdentity_should_returnFriendshipRequestCount() {
        when(profileRepository.findFriendshipRequestCountByProfileIdentity("identity")).thenReturn(1);

        assertEquals(1, profileService.findFriendshipRequestCountByProfileIdentity("identity"));
    }

    @Test
    public void acceptFriendship_should_deleteFriendshipRequestRelationship() {
        profileService.acceptFriendship("senderUserIdentity", "recipientUserIdentity");
        verify(profileRepository, times(1)).deleteFriendshipRequestRelationship("senderUserIdentity", "recipientUserIdentity");
    }

    @Test
    public void acceptFriendship_should_createFriendshipRelationshipForBothUsers() {
        profileService.acceptFriendship("senderUserIdentity", "recipientUserIdentity");
        verify(profileRepository, times(2)).createFriendshipRelationship(anyString(), anyString());
    }

    @Test
    public void unfriend_should_deleteFriendshipRequestRelationship() {
        profileService.declineFriendship("senderUserIdentity", "recipientUserIdentity");
        verify(profileRepository, times(1)).deleteFriendshipRequestRelationship("senderUserIdentity", "recipientUserIdentity");
    }

    @Test
    public void declineFriendship_should_deleteFriendshipRequestRelationship() {
        profileService.declineFriendship("senderUserIdentity", "recipientUserIdentity");
        verify(profileRepository, times(1)).deleteFriendshipRequestRelationship("senderUserIdentity", "recipientUserIdentity");
    }

    @Test
    public void unfriend_should_deleteFriendshipRelationshipForBothUsers() {
        profileService.unfriend("senderUserIdentity", "recipientUserIdentity");
        verify(profileRepository, times(2)).deleteFriendRelationship(anyString(), anyString());
    }

    @Test
    public void findFriendSuggestions_should_returnFriendSuggestions() {
        when(profileRepository.findFriendSuggestions("identity")).thenReturn(List.of("identity"));
        when(imageClient.findProfileImage("identity")).thenReturn("profileImage");

        List<FriendSuggestion> expected = List.of(FriendSuggestion.builder().profileIdentity("identity").build());
        List<FriendSuggestion> result = profileService.findFriendSuggestions("identity");

        assertEquals(expected.get(0).getProfileIdentity(), result.get(0).getProfileIdentity());
    }

    @Test
    public void findFriendSuggestions_should_throwException() {
        when(profileRepository.findFriendSuggestions("identity")).thenReturn(List.of("identity"));
        when(imageClient.findProfileImage("identity")).thenThrow(FeignException.class);

        assertThrows(ResourceAccessException.class, () -> profileService.findFriendSuggestions("identity"));
    }

    @Test
    public void findFriendsIdentitiesByProfileIdentity_should_returnFriendsIdentities() {
        when(profileRepository.findFriendsByProfileIdentity("identity")).thenReturn(Set.of("identity"));

        List<String> expected = List.of("identity");
        List<String> result = profileService.findFriendsIdentitiesByProfileIdentity("identity").stream().toList();

        assertEquals(expected.get(0), result.get(0));
    }
}
