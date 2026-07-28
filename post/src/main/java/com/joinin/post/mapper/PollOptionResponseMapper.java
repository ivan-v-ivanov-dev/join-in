package com.joinin.post.mapper;

import com.joinin.post.model.PollOption;
import com.joinin.post.model.PollOptionResponse;
import org.springframework.stereotype.Service;

@Service
public class PollOptionResponseMapper {

    public PollOptionResponse fromPollOption(PollOption pollOption) {
        if (pollOption == null) {
            return null;
        }

        return new PollOptionResponse(
                pollOption.getOptionIdentity(),
                pollOption.getOptionText(),
                pollOption.getVoteCount()
        );
    }
}
