package com.joinin.post.service;

import com.joinin.post.mapper.PostResponseMapper;
import com.joinin.post.model.PostResponse;
import com.joinin.post.repository.PostByAuthorRepository;
import com.joinin.post.repository.PostByGroupRepository;
import com.joinin.post.repository.PostByIdRepository;
import com.joinin.post.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostByIdRepository postByIdRepository;
    private final PostByAuthorRepository postByAuthorRepository;
    private final PostByGroupRepository postByGroupRepository;

    private final PostResponseMapper postResponseMapper;

    @Override
    public PostResponse retrievePostByIdentity(String identity) {
        return postByIdRepository.findById(identity).map(postResponseMapper::fromPostById).get();
    }

    @Override
    public List<PostResponse> retrievePostsByAuthor(String identity) {
        return postByAuthorRepository
                .findAllByAuthorIdentity(identity)
                .stream()
                .map(postResponseMapper::fromPostByAuthor)
                .toList();
    }
}
