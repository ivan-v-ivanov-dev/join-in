package com.joinin.post.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("poll_option")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PollOption {

    @Column("option_identity")
    private String optionIdentity;

    @Column("option_text")
    private String optionText;

    @Column("vote_count")
    private int voteCount;
}
