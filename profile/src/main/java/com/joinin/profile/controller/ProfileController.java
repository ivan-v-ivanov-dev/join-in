package com.joinin.profile.controller;

import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.join_in.common_models.ProfileRpProfileService;
import com.joinin.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profile/{identity}")
    public ProfileRpProfileService retrieveProfileByIdentity(@PathVariable String identity) {
        return profileService.retrieveProfileByIdentity(identity);
    }

    @GetMapping("/profile/{identity}/names")
    public String retrieveProfileNames(@PathVariable String identity) {
        return profileService.retrieveProfileNames(identity);
    }

    @GetMapping("/profiles/names")
    public List<ProfileRpProfileNamesProfileService> retrieveProfilesNames(@RequestParam List<String> identities) {
        return profileService.retrieveProfilesNames(identities);
    }
}
