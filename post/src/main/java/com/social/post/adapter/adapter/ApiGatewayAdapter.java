package com.social.post.adapter.adapter;

import com.social.model.dto.CommentRp;
import com.social.model.dto.PostRp;
import com.social.post.model.Comment;
import com.social.post.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.social.post.service.constants.ServiceConstants.*;

@Component
public class ApiGatewayAdapter {
    public PostRp fromPostToPostRp(Post post) {
        return PostRp.builder()
                .authorIdentity(post.getAuthorIdentity())
                .postIdentity(post.getPostIdentity())
                .content(post.getContent())
                .comments(fromCommentToCommentRp(post.getComments()))
                .postedAgo(calculatePostedAgo(post.getPostDate()))
                .build();
    }

    private List<CommentRp> fromCommentToCommentRp(List<Comment> comments) {
        return comments
                .stream()
                .map(comment -> CommentRp.builder()
                        .authorIdentity(comment.getAuthorIdentity())
                        .commentIdentity(comment.getCommentIdentity())
                        .content(comment.getContent())
                        .postedAgo(calculatePostedAgo(comment.getPostDate()))
                        .build()).toList();
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
