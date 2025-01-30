package com.project;

public class PersonagemNaoEncontradoNoMapaException extends Exception {
    public PersonagemNaoEncontradoNoMapaException() {
        super("O personagem não foi encontrado no mapa.");
    }

    public PersonagemNaoEncontradoNoMapaException(String message) {
        super(message);
    }
}
