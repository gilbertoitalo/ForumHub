package com.forum.service;

import java.util.List;

import com.forum.api.exception.DoubleTopicoException;
import com.forum.api.exception.ResourceNotFoundException;
import com.forum.dto.TopicoRequest;
import com.forum.dto.TopicoResponse;
import com.forum.model.Topic;
import com.forum.repository.TopicRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicoServImpl implements TopicoServ {

    private final TopicRepo topicRepository;

    @Override
    @Transactional
    public TopicoResponse criar(TopicoRequest request) {
        if (topicRepository.existsSimilarTitle(request.getTitulo())){
            throw new DoubleTopicoException();
        }
        Topic topico = new Topic();
        topico.setTitulo(request.getTitulo());
        topico.setMensagem(request.getMensagem());

        Topic topicoSalvo = topicRepository.save(topico);
        return TopicoResponse.fromEntity(topicoSalvo);
    }

    @Override
    public List<TopicoResponse> listarTodos() {
        List<Topic> topicos = topicRepository.findAll();
        return topicos.stream()
                .map(TopicoResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TopicoResponse buscarPorId(Long id) {
        Topic topico = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico", id));

        return TopicoResponse.fromEntity(topico);
    }

    @Override
    @Transactional
    public TopicoResponse atualizar(Long id, TopicoRequest request) {
        // Busca o tópico e verifica se existe
        return topicRepository.findById(id)
                .map(topico -> {
                    topico.setTitulo(request.getTitulo());
                    topico.setMensagem(request.getMensagem());
                    topico.setAutor(request.getAutor());
                    topico.setCurso(request.getCurso());

                    Topic topicoAtualizado = topicRepository.save(topico);
                    return TopicoResponse.fromEntity(topicoAtualizado);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Tópico", id));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!topicRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tópico", id);
        }
        topicRepository.deleteById(id);
    }

}
