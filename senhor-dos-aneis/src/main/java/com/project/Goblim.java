package com.project;

public class Goblim extends Arqueiro implements Monstro {
    public Goblim() {
        super(3, 6, 1, 20);
    }

    @Override
    public String toString() {
        return "M";
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }
}