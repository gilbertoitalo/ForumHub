package com.forum.repository;

import com.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);

    Boolean existsByName(String name);
}
