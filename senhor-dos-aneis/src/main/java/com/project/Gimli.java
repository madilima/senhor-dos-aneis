package com.project;

public class Gimli extends Guerreiro implements Anao{
    int quantidadeVezesBebidas = 0;

    public Gimli() {
        super(9, 2, 4, 60);
    }

    @Override
    public String toString() {
        return "I";
    }

    @Override
    public void beber() {
        this.quantidadeVezesBebidas++;
    }

    @Override
    public String falar() {
        if (quantidadeVezesBebidas >= 3) {
            return "What did I say? He can't hold his liquor!";
        }

        return "Let them come. There is one Dwarf yet in Moria who still draws breath";
    }
}
