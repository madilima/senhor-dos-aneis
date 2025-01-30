package com.project;

public class Aragorn extends Guerreiro implements Humano {
    public Aragorn() {
        super(10, 7, 6, 60);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 1);
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

}