package com.forum.dto;

import ch.qos.logback.core.status.Status;
import com.forum.model.Course;
import com.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record TopicDataWithReplies(
        Long id,
        String title,
        LocalDateTime creation_date,
        String message,
        Course course,
        Status status,
        List<ReplyData> replies
) {
    public TopicDataWithReplies(Topic topico) {
        this(topico.getId(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getMensagem(),
                topico.getCurso(),
                topico.getStatus(),
                topico.getReplies().stream()
                        .map(ReplyData::new)
                        .collect(Collectors.toList())
        );
    }
}
