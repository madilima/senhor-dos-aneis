package com.project;

public class Saruman extends Mago implements Maia {
    public Saruman() {
        super(2, 2, 9, 70); }

    @Override
    public String toString() {
        return "S";
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public Saruman ressucitar() {
       return null ;
    }
}
