package com.joinin.post.service.contract;

import com.join_in.common_models.PostRpPostService;

import java.util.List;

public interface PostService {
    List<PostRpPostService> retrievePostsByAuthor(String identity);

    int retrieveProfilePostsCount(String identity);

    List<String> retrievePostIdentitiesByAuthor(String identity);

    List<PostRpPostService> retrieveProfileFeedPosts(String identity);

    void postAPost(String profileIdentity, String groupIdentity, String content, byte[] imageBytes, String youtubeUrl, String pollQuestion, List<String> pollOptions);
}
