package com.social.reaction.service;

import com.social.reaction.model.Profile;
import com.social.reaction.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @Mock
    ProfileRepository profileRepository;
    @InjectMocks
    ProfileServiceImpl profileService;

    @Test
    public void findLikesAPostProfileCount_should_findLikes() {
        when(profileRepository.findLikesAPostProfileCount("postIdentity")).thenReturn(3);
        assertEquals(3, profileService.findLikesAPostProfileCount("postIdentity"));
    }

    @Test
    public void findLikesACommentProfileCount_should_findLikes() {
        when(profileRepository.findLikesACommentProfileCount("commentIdentity")).thenReturn(3);
        assertEquals(3, profileService.findLikesACommentProfileCount("commentIdentity"));
    }

    @Test
    public void findDislikesAPostProfileCount_should_findLikes() {
        when(profileRepository.findDislikesAPostProfileCount("postIdentity")).thenReturn(3);
        assertEquals(3, profileService.findDislikesAPostProfileCount("postIdentity"));
    }

    @Test
    public void findDislikesACommentProfileCount_should_findLikes() {
        when(profileRepository.findDislikesACommentProfileCount("commentIdentity")).thenReturn(3);
        assertEquals(3, profileService.findDislikesACommentProfileCount("commentIdentity"));
    }

    @Test
    public void findStarsAPostProfileCount_should_findLikes() {
        when(profileRepository.findStarsAPostProfileCount("postIdentity")).thenReturn(3);
        assertEquals(3, profileService.findStarsAPostProfileCount("postIdentity"));
    }

    @Test
    public void save_should_callRepository() {
        Profile profile = Profile.builder().identity("identity").build();
        profileService.save(profile);

        verify(profileRepository, times(1)).save(profile);
    }

    @Test
    public void findPeopleWhoReactedToPost_should_findProfileIdentities() {
        Set<String> userIdentities = Set.of("identity");
        when(profileRepository.findPeopleWhoReactedToPost("postIdentity")).thenReturn(userIdentities);

        assertEquals(userIdentities, profileService.findPeopleWhoReactedToPost("postIdentity"));
    }

    @Test
    public void findPeopleWhoLikedThePost_should_findProfileIdentities() {
        Set<String> userIdentities = Set.of("identity");
        when(profileRepository.findPeopleWhoLikedThePost("postIdentity")).thenReturn(userIdentities);

        assertEquals(userIdentities, profileService.findPeopleWhoLikedThePost("postIdentity"));
    }

    @Test
    public void findPeopleWhoDislikedThePost_should_findProfileIdentities() {
        Set<String> userIdentities = Set.of("identity");
        when(profileRepository.findPeopleWhoDislikedThePost("postIdentity")).thenReturn(userIdentities);

        assertEquals(userIdentities, profileService.findPeopleWhoDislikedThePost("postIdentity"));
    }

    @Test
    public void findPeopleWhoStaredThePost_should_findProfileIdentities() {
        Set<String> userIdentities = Set.of("identity");
        when(profileRepository.findPeopleWhoStaredThePost("postIdentity")).thenReturn(userIdentities);

        assertEquals(userIdentities, profileService.findPeopleWhoStaredThePost("postIdentity"));
    }
}
