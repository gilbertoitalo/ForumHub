package com.forum.repository;

import com.forum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
}
