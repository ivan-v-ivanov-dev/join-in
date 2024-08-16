package com.social.mvc.adapter;

import com.social.model.dto.ProfileRp;
import com.social.mvc.model.Profile;
import org.mapstruct.Mapper;

@Mapper
public interface ProfileAdapter {

    Profile fromProfileRpToProfile(ProfileRp byIdentity);
}
