package com.joinin.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Builder
@ToString
@Document(collection = "groups")
public class Group {

    @Id
    private String id;
    @Indexed(unique = true)
    private String identity;
    private String imageUrl;
}
