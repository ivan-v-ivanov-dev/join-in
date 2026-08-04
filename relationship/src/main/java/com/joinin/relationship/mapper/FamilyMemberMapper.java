package com.joinin.relationship.mapper;

import com.join_in.common_models.FamilyMemberRpRelationshipService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.joinin.relationship.model.FamilyMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberMapper {

    public FamilyMemberRpRelationshipService fromFamilyMembertoFamilyMemberRpRelationshipService(FamilyMember familyMember,
                                                                                                 List<ProfileImageRpMediaService> profileImages,
                                                                                                 List<ProfileRpProfileNamesProfileService> profileNames) {
        String profileImage = profileImages
                .stream()
                .filter(e -> e.identity().equals(familyMember.getIdentity()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No profile image");

        String firstName = profileNames
                .stream()
                .filter(e -> e.identity().equals(familyMember.getIdentity()))
                .map(ProfileRpProfileNamesProfileService::firstName)
                .findFirst()
                .orElse("No name");

        String lastName = profileNames
                .stream()
                .filter(e -> e.identity().equals(familyMember.getIdentity()))
                .map(ProfileRpProfileNamesProfileService::lastName)
                .findFirst()
                .orElse("No name");

        return new FamilyMemberRpRelationshipService(
                familyMember.getIdentity(),
                familyMember.getRelationshipType(),
                profileImage,
                firstName,
                lastName);
    }
}
