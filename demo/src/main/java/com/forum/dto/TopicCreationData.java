package com.forum.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreationData(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long course_id
){
}
