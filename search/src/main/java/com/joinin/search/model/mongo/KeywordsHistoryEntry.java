package com.joinin.search.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class KeywordsHistoryEntry {

    private String keyword;

    private LocalDateTime searchedAt;
}
