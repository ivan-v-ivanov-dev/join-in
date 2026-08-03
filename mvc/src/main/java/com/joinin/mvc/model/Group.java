package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Group {
    private String identity;
    private String name;
    private String description;
    private String image;
}
