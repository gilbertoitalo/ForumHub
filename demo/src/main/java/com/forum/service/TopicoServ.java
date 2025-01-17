package com.forum.service;

import com.forum.dto.TopicoRequest;
import com.forum.dto.TopicoResponse;

import java.util.List;

public interface TopicoServ {
    TopicoResponse criar(TopicoRequest request);

    List<TopicoResponse> listarTodos();

    TopicoResponse buscarPorId(Long id);

    TopicoResponse atualizar(Long id, TopicoRequest request);

    void deletar(Long id);
}
