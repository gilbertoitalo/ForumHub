package com.forum.dto;

import com.forum.model.Topic;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicoResponse {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private String autor;
    private String curso;

    public static TopicoResponse fromEntity(Topic topico) {
        TopicoResponse response = new TopicoResponse();
        response.setId(topico.getId());
        response.setTitulo(topico.getTitulo());
        response.setMensagem(topico.getMensagem());
        response.setDataCriacao(topico.getDataCriacao());
        response.setStatus(topico.getStatus().toString());
        response.setAutor(topico.getAutor());
        response.setCurso(topico.getCurso());
        return response;
    }
}
