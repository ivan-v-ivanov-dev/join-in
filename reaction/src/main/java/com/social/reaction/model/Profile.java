package com.social.reaction.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serializable;

@Node(labels = "Profile")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile implements Serializable {

    @Id
    private String identity;

}
