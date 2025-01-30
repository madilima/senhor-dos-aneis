package com.project;

public class Gandalf extends Mago implements Maia {
    public Gandalf() {
        super(2, 3, 10, 80);
    }

    public String toString() {
        return "G";
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public Gandalf ressucitar() {
        if (getConstituicao() == 0) {
            return new Gandalf();
        }
        return this;
    }
}