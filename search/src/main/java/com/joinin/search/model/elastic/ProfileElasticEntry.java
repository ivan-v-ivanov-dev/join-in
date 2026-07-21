package com.joinin.search.model.elastic;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@Setting(shards = 1, replicas = 0)
@Document(indexName = "profiles")
public class ProfileElasticEntry {

    @Id
    private String identity;

    @MultiField(
            mainField = @Field(
                    type = FieldType.Text,
                    analyzer = "standard"),
            otherFields = @InnerField(
                    suffix = "keyword",
                    type = FieldType.Keyword))
    private String firstName;

    @MultiField(
            mainField = @Field(
                    type = FieldType.Text,
                    analyzer = "standard"),
            otherFields = @InnerField(
                    suffix = "keyword",
                    type = FieldType.Keyword))
    private String lastName;
}
