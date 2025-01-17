package com.forum.repository;

import com.forum.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepo extends JpaRepository<Reply, Long> {
    @Query("SELECT r FROM Reply r WHERE r.topic.id = :topicId")
    List<Reply> findAllFromTopic(@Param("topicId")Long id);
}
