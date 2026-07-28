package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("posts_by_identity")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostByIdEntity {

    @PrimaryKey("post_identity")
    private String postIdentity;

    @Column("author_identity")
    private String authorIdentity;

    @Column("group_identity")
    private String groupIdentity;

    @Column("content")
    private String content;

    @Column("has_text")
    private boolean hasText;

    @Column("has_image")
    private boolean hasImage;

    @Column("has_video")
    private boolean hasVideo;

    @Column("is_poll")
    private boolean poll;

    @Column("image_identity")
    private String imageIdentity;

    @Column("youtube_url")
    private String youtubeUrl;

    @Column("poll_question")
    private String pollQuestion;

    @Column("poll_options")
    private List<@Frozen PollOption> pollOptions;

    @Column("created_at")
    private LocalDateTime createdAt;
}