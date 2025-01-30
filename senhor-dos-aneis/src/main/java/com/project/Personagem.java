package com.project;

public abstract class Personagem {
    private int forca;
    private int agilidade;
    private int inteligencia;
    private int constituicao;

    protected Personagem(int forca, int agilidade, int inteligencia, int constituicao) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
    }

    public abstract void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException;

    public abstract void mover(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException;

    public void setConstituicao(int constituicao) {
        if (constituicao < 0) {
            throw new IllegalArgumentException("Constituição não pode ser menor que zero");
        }
        if (constituicao > this.constituicao) {
            throw new IllegalArgumentException("Constituição não pode ser aumentada");
        }
        this.constituicao = constituicao;
    }

    public int getConstituicao() {
        return this.constituicao;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }

    public int getForca() {
        return this.forca;
    }

    public int getAgilidade() {
        return this.agilidade;
    }

}



