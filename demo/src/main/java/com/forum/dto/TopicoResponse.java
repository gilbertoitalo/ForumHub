package com.forum.dto;

import com.forum.model.Topico;
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

    public static TopicoResponse fromEntity(Topico topico) {
        TopicoResponse response = new TopicoResponse();
        response.setId(topico.getId());
        response.setTitulo(topico.getTitulo());
        response.setMensagem(topico.getMensagem());
        response.setDataCriacao(topico.getDataCriacao());
        return response;
    }
}