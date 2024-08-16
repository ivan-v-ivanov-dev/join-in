package com.social.relationship.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serializable;

@Node(labels = "Profile")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Profile implements Serializable {

    @Id
    @Property("identity")
    private String identity;

}
