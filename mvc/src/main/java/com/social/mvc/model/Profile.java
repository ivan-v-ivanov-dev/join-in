package com.social.mvc.model;

import com.social.model.dto.FriendRp;
import com.social.model.dto.FriendshipRequestRp;
import com.social.model.dto.NotificationRp;
import com.social.model.dto.PostRp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
public class Profile {

    private String identity;

    private String firstName;

    private String lastName;

    private String email;

    private String aboutMe;

    private String mobile;

    private String city;

    private String country;

    private LocalDate birthDate;

    private String gender;

    private LocalDate joined;

    private String status;

    private String website;

    private String hobbies;

    private String profileImage;

    private String backgroundImage;

    Map<String, List<String>> albums;

    List<Post> posts;

    List<Friend> friends;

    List<FriendshipRequestRp> friendshipRequests;

    List<NotificationRp> notifications;

}
