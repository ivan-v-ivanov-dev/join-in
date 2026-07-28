package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("feed_by_user")
public class FeedUserEntity {

    @PrimaryKey
    private FeedUserPrimaryKey primaryKey;

    /*
     * The user who created the post.
     *
     * This may be different from primaryKey.userIdentity.
     */
    @Column("author_identity")
    private String authorIdentity;

    /*
     * Present only when the post belongs to a group.
     */
    @Column("group_identity")
    private String groupIdentity;

    @Column("content")
    private String content;

    @Column("has_text")
    private Boolean hasText;

    @Column("has_image")
    private Boolean hasImage;

    @Column("has_video")
    private Boolean hasVideo;

    @Column("is_poll")
    private Boolean poll;

    @Column("image_identity")
    private String imageIdentity;

    @Column("youtube_url")
    private String youtubeUrl;

    @Column("poll_question")
    private String pollQuestion;

    @Column("poll_options")
    private List<PollOption> pollOptions;
}
