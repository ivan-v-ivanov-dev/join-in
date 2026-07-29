package com.joinin.post.service;

import com.join_in.common_models.CommentRpPostService;
import com.join_in.common_models.PostRpPostService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.joinin.post.mapper.CommentResponseMapper;
import com.joinin.post.mapper.PostResponseMapper;
import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.repository.CommentRepository;
import com.joinin.post.repository.PostByAuthorRepository;
import com.joinin.post.service.contract.PostService;
import com.joinin.post.service.feign.MediaServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostByAuthorRepository postByAuthorRepository;
    private final CommentRepository commentRepository;
    private final PostResponseMapper postResponseMapper;
    private final CommentResponseMapper commentResponseMapper;
    private final MediaServiceClient mediaServiceClient;

    @Override
    public List<PostRpPostService> retrievePostsByAuthor(String identity) {
        List<PostByAuthorEntity> postEntities = postByAuthorRepository.findAllByAuthorIdentity(identity);
        log.info("Retrieve posts by author identity: " + identity);

        List<PostRpPostService> posts = postEntities.stream()
                .map(postEntity -> {
                    String postIdentity = postEntity.getKey().getPostIdentity();
                    List<CommentEntity> commentEntities = commentRepository.findByPostIdentity(postIdentity);
                    List<String> commentAuthorIdentities = commentEntities.stream().map(CommentEntity::getAuthorIdentity).toList();
                    List<ProfileImageRpMediaService> profileImagesRpMediaServices = mediaServiceClient.retrieveProfileImagesForProfiles(commentAuthorIdentities);
                    //TODO Call profile service to retrieve user names
                    List<CommentRpPostService> commentRpPostServices = commentEntities.stream()
                            .map(e -> commentResponseMapper.fromCommentEntitytoCommentRpPostService(e, profileImagesRpMediaServices))
                            .toList();
                    return postResponseMapper.fromPostByAuthortoPostRpPostService(postEntity, commentRpPostServices);
                })
                .toList();
        log.info("Retrieve comments for all posts");
        return posts;
    }
}
