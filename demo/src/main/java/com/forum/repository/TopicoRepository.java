package com.forum.repository;

import com.forum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository
@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
