package com.project;

public class Legolas extends Arqueiro implements Elfo {
    public Legolas() {
        super(5, 10, 6, 80);
    }

    @Override
    public String toString() {
        return "L";
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";

    }
}