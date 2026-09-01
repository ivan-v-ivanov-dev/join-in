package com.joinin.mvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostRq {
    private String content;

    private MultipartFile image;

    private String youtubeUrl;

    private String pollQuestion;

    private List<String> pollOptions = new ArrayList<>();
}
