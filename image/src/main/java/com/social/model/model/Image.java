package com.social.model.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Image {

    @Id
    private String id;
    private String type;
    private String albumName;
    private String image;

}
