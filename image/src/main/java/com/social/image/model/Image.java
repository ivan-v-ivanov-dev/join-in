package com.social.image.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Image {

    @Id
    private String id;
    private String type;
    private String image;

}
