package com.joinin.post.service;

import com.joinin.post.mapper.CommentResponseMapper;
import com.joinin.post.mapper.PostResponseMapper;
import com.joinin.post.model.CommentResponse;
import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.model.PostResponse;
import com.joinin.post.repository.CommentRepository;
import com.joinin.post.repository.PostByAuthorRepository;
import com.joinin.post.repository.PostByIdRepository;
import com.joinin.post.service.contract.PostService;
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

    @Override
    public List<PostResponse> retrievePostsByAuthor(String identity) {
        List<PostByAuthorEntity> postEntities = postByAuthorRepository.findAllByAuthorIdentity(identity);
        log.info("Retrieve posts by author identity: " + identity);

        List<PostResponse> posts = postEntities.stream()
                .map(postEntity -> {

                    String postIdentity = postEntity.getKey().getPostIdentity();

                    List<CommentResponse> comments = commentRepository
                            .findByPostIdentity(postIdentity)
                            .stream()
                            .map(commentResponseMapper::fromCommentEntity)
                            .toList();

                    return postResponseMapper.fromPostByAuthor(postEntity, comments);
                })
                .toList();
        log.info("Retrieve comments for all posts");
        return posts;
    }
}
