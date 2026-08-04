package com.joinin.mvc.mappers;

import com.join_in.common_models.FamilyMemberRpGatewayService;
import com.joinin.mvc.model.FamilyMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilyMemberMapper {

    FamilyMember fromFamilyMemberRpGatewayServicetoFamilyMember(FamilyMemberRpGatewayService familyMemberRpGatewayService);
}
