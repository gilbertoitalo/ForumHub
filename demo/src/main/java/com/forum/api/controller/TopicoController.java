package com.forum.api.controller;

import com.forum.dto.TopicoRequest;
import com.forum.dto.TopicoResponse;
import com.forum.repository.TopicRepo;
import com.forum.service.TopicoServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    private final TopicRepo topicRepository;
    @Autowired
    private final TopicoServ topicoService;

    public TopicoController(TopicRepo topicRepository, TopicoServ topicoService) {
        this.topicRepository = topicRepository;
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> criar(@RequestBody @Valid TopicoRequest request) {
        TopicoResponse response = topicoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listarTodos() {
        List<TopicoResponse> topicos = topicoService.listarTodos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponse> getTopicoId (@PathVariable Long id){
        TopicoResponse topicos = topicoService.buscarPorId(id);
        if (topicos != null) {
            return ResponseEntity.ok(topicos);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TopicoRequest request) {
        TopicoResponse response = topicoService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }
}
