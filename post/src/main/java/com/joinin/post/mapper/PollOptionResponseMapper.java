package com.joinin.post.mapper;

import com.join_in.common_models.PollOptionRpPostService;
import com.joinin.post.model.PollOption;
import org.springframework.stereotype.Service;

@Service
public class PollOptionResponseMapper {

    public PollOptionRpPostService fromPollOptiontoPollOptionRpPostService(PollOption pollOption) {
        if (pollOption == null) {
            return null;
        }

        return new PollOptionRpPostService(
                pollOption.getOptionIdentity(),
                pollOption.getOptionText(),
                pollOption.getVoteCount()
        );
    }
}
