package com.forum.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoRequest {
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "A mensagem é obrigatória")
    @Size(min = 10, message = "A mensagem deve ter no mínimo 10 caracteres")
    private String mensagem;

    @NotBlank(message = "O autor é obrigatório")
    private String autor;

    @NotBlank(message = "O curso é obrigatório")
    private String curso;
}

