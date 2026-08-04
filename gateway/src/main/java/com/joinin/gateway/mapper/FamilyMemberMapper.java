package com.joinin.gateway.mapper;

import com.join_in.common_models.FamilyMemberRpGatewayService;
import com.join_in.common_models.FamilyMemberRpRelationshipService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilyMemberMapper {
    FamilyMemberRpGatewayService fromFamilyMemberRpRelationshipServicetoFamilyMemberRpGatewayService(FamilyMemberRpRelationshipService familyMemberRpRelationshipService);
}
