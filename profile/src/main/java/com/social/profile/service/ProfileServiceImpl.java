package com.social.profile.service;

import com.social.profile.model.Profile;
import com.social.profile.model.dto.PostDto;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.ProfileService;
import com.social.profile.service.feign.ImageClient;
import com.social.profile.service.feign.PostClient;
import com.social.profile.service.feign.ReactionClient;
import com.social.profile.service.feign.RelationshipClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.social.profile.service.constants.ServiceConstants.*;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final PostClient postClient;
    private final ReactionClient reactionClient;
    private final RelationshipClient relationshipClient;
    private final ImageClient imageClient;

    public ProfileServiceImpl(ProfileRepository profileRepository,
                              PostClient postClient,
                              ReactionClient reactionClient,
                              RelationshipClient relationshipClient,
                              ImageClient imageClient) {
        this.profileRepository = profileRepository;
        this.postClient = postClient;
        this.reactionClient = reactionClient;
        this.relationshipClient = relationshipClient;
        this.imageClient = imageClient;
    }

    @Override
    public Profile findByIdentity(String identity) {
        Profile profile = profileRepository.findByIdentity(identity);
        profile.setProfileImage(imageClient.findProfileImage(identity));
        profile.setBackgroundImage(imageClient.findProfileBackgroundImage(identity));
        profile.setAlbumImages(imageClient.findProfileAlbumImage(identity));
        return profile;
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<PostDto> findAllPosts(String identity) {
        List<PostDto> posts = postClient.findAllPostsByAuthorIdentity(identity);
        posts.forEach(post -> {
            String firstName = profileRepository.findProfileFirstName(identity);
            String lastName = profileRepository.findProfileLastName(identity);
            post.setAuthor(String.format(AUTHOR_NAME_TEMPLATE, firstName, lastName));
            post.setAuthorPhoto(imageClient.findProfileImage(identity));

            int likes = reactionClient.findLikesAPostProfileCount(post.getPostIdentity());
            post.setLikes(likes);

            int dislikes = reactionClient.findDislikesAPostProfileCount(post.getPostIdentity());
            post.setDislikes(dislikes);

            int stars = reactionClient.findStarsAPostProfileCount(post.getPostIdentity());
            post.setStars(stars);

        });
        posts.forEach(this::calculatePostedAgo);
        return posts;
    }

    @Override
    public int findUserPostsCount(String identity) {
        return postClient.findAuthorPostsCount(identity);
    }

    @Override
    public int findFriendsCount(String identity) {
        return relationshipClient.findFriendCountByProfileIdentity(identity);
    }

    private void calculatePostedAgo(PostDto postDto) {
        LocalDate now = LocalDate.now();

        if (now.isAfter(postDto.getPostDate().plusYears(1))) {
            if (now.isBefore(postDto.getPostDate().plusYears(2))) {
                postDto.setPostedAgo(ONE_YEAR_AGO);
                return;
            }

            Period period = Period.between(postDto.getPostDate(), now);
            int years = period.getYears();
            postDto.setPostedAgo(String.format(SEVERAL_YEARS_AGO_TEMPLATE, years));
        } else if (now.isAfter(postDto.getPostDate().plusMonths(1))) {
            if (now.isBefore(postDto.getPostDate().plusMonths(2))) {
                postDto.setPostedAgo(ONE_MONTH_AGO);
                return;
            }

            Period period = Period.between(postDto.getPostDate(), now);
            int months = period.getMonths();
            postDto.setPostedAgo(String.format(SEVERAL_MONTHS_AGO_TEMPLATE, months));
        } else {
            if (now.isBefore(postDto.getPostDate().plusDays(2))) {
                postDto.setPostedAgo(ONE_DAY_AGO);
                return;
            }

            Period period = Period.between(postDto.getPostDate(), now);
            int days = period.getDays();
            postDto.setPostedAgo(String.format(SEVERAL_DAYS_AGO_TEMPLATE, days));
        }
    }
}
