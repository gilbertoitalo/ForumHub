package com.forum.dto;

public record UserUpdate(
        String name,
        String email,
        String password,
        String role
) {
}
