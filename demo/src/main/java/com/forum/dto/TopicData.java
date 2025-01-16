package com.forum.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TopicData(
        Long id,
        String title,
        LocalDateTime creation_date,
        String message,
        String course,
        Status status
) {
    public TopicData(Topic topic) {
        this(topic.getId(), topic.getTitle(),topic.getCreationDate() ,topic.getMessage(), topic.getCourse().getName(), topic.getStatus());
    }
}
