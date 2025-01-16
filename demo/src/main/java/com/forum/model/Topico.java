package com.forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String titulo;

    @NotBlank
    @Size(min = 10)
    private String mensagem;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;

    @NotNull
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @NotBlank
    private String status;

    private List<Reply> replies = new ArrayList<>();

    // Getters e Setters
    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus(){
        return status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }




}



