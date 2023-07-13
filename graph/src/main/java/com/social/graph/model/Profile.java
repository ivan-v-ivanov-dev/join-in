package com.social.graph.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Profile")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue
    private long id;

    private String identity;

}
