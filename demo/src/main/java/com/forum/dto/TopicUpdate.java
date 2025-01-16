package com.forum.dto;

import ch.qos.logback.core.status.Status;

public record TopicUpdate(
        String title,
        String message,
        Status status,
        Long course_id
) {}
