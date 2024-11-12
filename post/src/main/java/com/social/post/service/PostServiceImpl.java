package com.social.post.service;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import com.social.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

import static com.social.post.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static com.social.post.service.constants.LoggerConstants.RETRIEVE_POST_TEMPLATE;
import static com.social.post.service.constants.ServiceConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createCollection(String identity) {
        postRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }

    @Override
    public Post findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity) {
        Post post = postRepository.findByAuthorIdentityAndPostIdentity(postIdentity, format(COLLECTION_TEMPLATE, authorIdentity));
        post.setPostedAgo(calculatePostedAgo(post.getPostDate()));
        post.getComments().forEach(comment -> comment.setPostedAgo(calculatePostedAgo(comment.getPostDate())));
        log.info(format(RETRIEVE_POST_TEMPLATE, post.getPostIdentity()));
        return post;
    }

    private String calculatePostedAgo(LocalDate postDate) {
        LocalDate now = LocalDate.now();

        if (now.isAfter(postDate.plusYears(1))) {
            if (now.isBefore(postDate.plusYears(2))) {
                return ONE_YEAR_AGO;
            }

            Period period = Period.between(postDate, now);
            int years = period.getYears();
            return String.format(SEVERAL_YEARS_AGO_TEMPLATE, years);
        } else if (now.isAfter(postDate.plusMonths(1))) {
            if (now.isBefore(postDate.plusMonths(2))) {
                return ONE_MONTH_AGO;
            }

            Period period = Period.between(postDate, now);
            int months = period.getMonths();
            return String.format(SEVERAL_MONTHS_AGO_TEMPLATE, months);
        } else {
            if (now.isBefore(postDate.plusDays(2))) {
                return ONE_DAY_AGO;
            }

            Period period = Period.between(postDate, now);
            int days = period.getDays();
            return String.format(SEVERAL_DAYS_AGO_TEMPLATE, days);
        }
    }
}
