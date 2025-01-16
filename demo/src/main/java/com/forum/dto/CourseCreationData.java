package com.forum.dto;

import com.forum.model.Category;
import com.forum.model.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CourseCreationData(
        @NotBlank
        String name,
        @NotNull
        Category category) {

    public CourseCreationData(Course course){
        this(course.getName(), course.getCategory());
    }

}
