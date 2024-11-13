package com.social.reaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = "Post")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {

    @Id
    @Property("identity")
    private String identity;
}
