package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table("posts_by_group")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostByGroupEntity {

    @PrimaryKey
    private PostByGroupKey key;

    @Column("author_identity")
    private String authorIdentity;

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
    private List<PollOption> pollOptions;
}
