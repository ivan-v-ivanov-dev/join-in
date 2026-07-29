package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PollOption {

    private String optionIdentity;
    private String optionText;
    private int voteCount;
}
