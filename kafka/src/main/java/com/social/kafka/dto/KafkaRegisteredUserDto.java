package com.social.kafka.dto;

import lombok.Builder;

@Builder
public class KafkaRegisteredUserDto {

    private String identity;
    private String email;
}
