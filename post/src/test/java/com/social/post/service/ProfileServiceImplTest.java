package com.social.post.service;

import com.social.post.repository.contract.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @Mock
    ProfileRepository profileRepository;
    @InjectMocks
    ProfileServiceImpl profileService;

    @Test
    public void findAllUsersCommentingThePost_should_returnUserIdentities() {
        Set<String> expected = Set.of("userIdentity");
        when(profileRepository.findAllUsersCommentingThePost(anyString(), anyString())).thenReturn(expected);

        assertEquals(expected, profileService.findAllUsersCommentingThePost(anyString(), anyString()));
    }
}
