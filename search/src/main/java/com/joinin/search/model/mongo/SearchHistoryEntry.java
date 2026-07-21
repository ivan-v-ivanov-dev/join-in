package com.joinin.search.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@ToString
@Document(collection = "search_history")
public class SearchHistoryEntry {

    @Id
    private String id;

    @Indexed(unique = true)
    private String identity;

    @Builder.Default
    private List<KeywordsHistoryEntry> keywordsHistoryEntries = new ArrayList<>();
}
