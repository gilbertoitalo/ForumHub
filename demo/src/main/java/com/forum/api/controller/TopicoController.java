package com.forum.api.controller;

import com.forum.dto.TopicoRequest;
import com.forum.dto.TopicoResponse;
import com.forum.model.Topico;
import com.forum.repository.TopicoRepository;
import com.forum.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    private final TopicoService topicoService;

    public TopicoController(TopicoRepository topicoRepository, TopicoService topicoService) {
        this.topicoRepository = topicoRepository;
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
    public ResponseEntity<TopicoResponse> buscarPorId(@PathVariable Long id) {
        TopicoResponse response = topicoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TopicoRequest request) {
        TopicoResponse response = topicoService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
