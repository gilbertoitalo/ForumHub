package com.forum.dto;

import com.forum.model.User;
import com.forum.model.UserRole;

public record UserDetails(
        String nome,
        String email,
        UserRole role
) {
    public UserDetails(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
