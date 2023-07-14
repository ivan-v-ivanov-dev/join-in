package com.social.graph.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

@Node(labels = "Profile")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile implements Serializable {

    @Id
    @Property("identity")
    private String identity;

    @Property("name")
    private String name;

}
