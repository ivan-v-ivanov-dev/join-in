package com.joinin.mvc.mappers;

import com.join_in.common_models.EditProfileGatewayRq;
import com.joinin.mvc.model.EditProfileRq;
import com.joinin.mvc.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class EditProfileMapper {

    public EditProfileRq fromProfileToEditProfileRq(Profile profile) {

        EditProfileRq rq = new EditProfileRq();

        rq.setFirstName(profile.getFirstName());
        rq.setLastName(profile.getLastName());
        rq.setAboutMe(profile.getAboutMe());

        rq.setMobile(profile.getMobile());
        rq.setAddress(profile.getAddress());

        rq.setBirthDate(profile.getBirthDate());
        rq.setBirthYear(profile.getBirthYear());
        rq.setBirthplace(profile.getBirthplace());

        rq.setLivesIn(profile.getLivesIn());

        rq.setGender(profile.getGender());
        rq.setInterestedIn(profile.getInterestedIn());
        rq.setLanguage(profile.getLanguage());

        rq.setJoined(profile.getJoined());
        rq.setStatus(profile.getStatus());

        rq.setPhoneNumber(profile.getPhoneNumber());

        rq.setWebsite(profile.getWebsite());
        rq.setSocialLink(profile.getSocialLink());

        rq.setHobbies(profile.getHobbies());

        rq.setWork(profile.getWork());
        rq.setProfessionalSkills(
                profile.getProfessionalSkills()
        );

        rq.setCollege(profile.getCollege());

        rq.setCurrentCity(profile.getCurrentCity());
        rq.setHometown(profile.getHometown());
        rq.setOtherPlacesLived(
                profile.getOtherPlacesLived()
        );

        rq.setPassword(null);
        rq.setConfirmPassword(null);

        return rq;
    }

    public EditProfileGatewayRq fromEditProfileRqToEditProfileGatewayRq(EditProfileRq rq) {

        return new EditProfileGatewayRq(
                rq.getFirstName(),
                rq.getLastName(),
                rq.getAboutMe(),
                rq.getMobile(),
                rq.getAddress(),
                rq.getBirthDate(),
                rq.getBirthYear(),
                rq.getBirthplace(),
                rq.getLivesIn(),
                rq.getGender(),
                rq.getInterestedIn(),
                rq.getLanguage(),
                rq.getJoined(),
                rq.getStatus(),
                rq.getPhoneNumber(),
                rq.getWebsite(),
                rq.getSocialLink(),
                rq.getHobbies(),
                rq.getWork(),
                rq.getProfessionalSkills(),
                rq.getCollege(),
                rq.getCurrentCity(),
                rq.getHometown(),
                rq.getOtherPlacesLived(),
                rq.getPassword(),
                rq.getConfirmPassword()
        );
    }
}
