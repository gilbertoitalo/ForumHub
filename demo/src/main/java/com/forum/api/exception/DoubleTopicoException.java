package com.forum.api.exception;

public class DoubleTopicoException extends RuntimeException {
    public DoubleTopicoException(){
        super("Já existe um tópico e mensagem");
    }
}
