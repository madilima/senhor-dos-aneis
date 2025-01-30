package com.project;

public class Urukhai extends Guerreiro implements Monstro, Humano {
    public Urukhai() {
        super(8, 6, 3, 45);
    }

    @Override
    public String toString() {
        return "U";
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 2);
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }
}