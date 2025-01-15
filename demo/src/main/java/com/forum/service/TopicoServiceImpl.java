package com.forum.service;

import java.util.List;

import com.forum.api.exception.DoubleTopicoException;
import com.forum.api.exception.ResourceNotFoundException;
import com.forum.dto.TopicoRequest;
import com.forum.dto.TopicoResponse;
import com.forum.model.Topico;
import com.forum.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;

    @Override
    @Transactional
    public TopicoResponse criar(TopicoRequest request) {
        if (topicoRepository.existsByTituloAndMensagem(request.getTitulo(),request.getMensagem())){
            throw new DoubleTopicoException();
        }
        Topico topico = new Topico();
        topico.setTitulo(request.getTitulo());
        topico.setMensagem(request.getMensagem());

        Topico topicoSalvo = topicoRepository.save(topico);
        return TopicoResponse.fromEntity(topicoSalvo);
    }

    @Override
    public List<TopicoResponse> listarTodos() {
        return topicoRepository.findAll()
                .stream()
                .map(TopicoResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TopicoResponse buscarPorId(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico", id));

        return TopicoResponse.fromEntity(topico);
    }

    @Override
    @Transactional
    public TopicoResponse atualizar(Long id, TopicoRequest request) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico", id));

        topico.setTitulo(request.getTitulo());
        topico.setMensagem(request.getMensagem());

        Topico topicoAtualizado = topicoRepository.save(topico);
        return TopicoResponse.fromEntity(topicoAtualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tópico", id);
        }
        topicoRepository.deleteById(id);
    }
}
