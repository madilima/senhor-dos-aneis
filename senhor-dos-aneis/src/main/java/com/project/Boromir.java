package com.project;

public class Boromir extends Guerreiro implements Humano {
    public Boromir() {
        super(7, 6, 3, 40);
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 2);
    }

}
