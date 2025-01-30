package com.project;

import java.util.Objects;

public class Mapa {
    private final Personagem[] personagens;

    public Mapa() {
        personagens = new Personagem[10];
    }

    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (personagens[posicao] != null) throw new PosicaoOcupadaException("Posição " + posicao + " já está ocupada.");
        for (Personagem p : personagens) {
            if (p != null && Objects.equals(p.toString(), personagem.toString())) {
                throw new PersonagemJaEstaNoMapaException("O personagem " + personagem.toString() + " já está no mapa.");
            }
        }
        personagens[posicao] = personagem;
    }

    public void mover(int posicao, int proximaPosicao) {
        try {
            if (personagens[proximaPosicao] != null && personagens[proximaPosicao].getConstituicao() > 0) {
                return;
            }

            Personagem personagem = personagens[posicao];
            personagens[posicao] = null;

            personagens[proximaPosicao] = personagem;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return;
        }
    }

    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        for (int i = 0; i < personagens.length; i++) {
            if (personagens[i] != null && personagens[i].equals(personagem)) return i;
        }
        throw new PersonagemNaoEncontradoNoMapaException();
    }

    public Personagem buscarCasa(int posicao) {
        try {
            Personagem personagem = personagens[posicao];

            if (personagem == null) {
                return null;
            }

            if (personagem.getConstituicao() == 0) {
                return null;
            }

            return personagem;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return null;
        }
    }

    public String exibir() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Personagem p : personagens) {
            if (p != null && p.getConstituicao() > 0) {
                sb.append(p);
            } else {
                sb.append(" ");
            }
            sb.append("|");
        }
        return sb.toString();
    }

    public Personagem[] getPersonagem() {
        return personagens;
    }

    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Personagem p : personagens) {
            if (p != null && p.getConstituicao() > 0) {
                sb.append(p).append(":").append(p.getConstituicao());
            } else {
                sb.append(" ");
            }
            sb.append("|");
        }
        return sb.toString();
    }

}
