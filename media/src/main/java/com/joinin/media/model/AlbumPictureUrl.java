package com.joinin.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class AlbumPictureUrl {

    private String url;
    private LocalDateTime uploadedOn;
}
