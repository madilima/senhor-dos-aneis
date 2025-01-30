package com.project;

public class PersonagemJaEstaNoMapaException extends Exception {
    public PersonagemJaEstaNoMapaException() {
        super("Este personagem já está no mapa.");
    }

    public PersonagemJaEstaNoMapaException(String message) {
        super(message);
    }
}
