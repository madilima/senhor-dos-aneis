package com.project;

public abstract class Arqueiro extends Personagem {
    protected Arqueiro(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }

    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        boolean isMembroSociedade = new Sociedade().isMembroSociedade(this.getClass());

        int posicao = mapa.buscarPosicao(this);

        int[] posicoesParaAtacar = new int[3];

        if (isMembroSociedade) {
            posicoesParaAtacar[0] = posicao + 3;
            posicoesParaAtacar[1] = posicao + 2;
            posicoesParaAtacar[2] = posicao + 1;
        } else {
            posicoesParaAtacar[0] = posicao - 3;
            posicoesParaAtacar[1] = posicao - 2;
            posicoesParaAtacar[2] = posicao - 1;
        }

        boolean jaAtacou = false;

        for (int i = 0; i < posicoesParaAtacar.length; i++) {
            int distancia = Math.abs(posicao - posicoesParaAtacar[i]);

            Personagem personagem = mapa.buscarCasa(posicoesParaAtacar[i]);

            if (personagem == null || jaAtacou) {
                continue;
            }

            int dano = distancia * this.getAgilidade();

            boolean isPersonagemMembroSociedade = new Sociedade().isMembroSociedade(personagem.getClass());

            if ((isMembroSociedade && !isPersonagemMembroSociedade) || (!isMembroSociedade && isPersonagemMembroSociedade)) {
                int constituicao = personagem.getConstituicao() - dano;

                if (constituicao < 0) {
                    constituicao = 0;
                }

                personagem.setConstituicao(constituicao);
                jaAtacou = true;
            }
        }
    }

    public void mover(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        boolean isMembroSociedade = new Sociedade().isMembroSociedade(this.getClass());

        for (int i = 0; i <= 1; i++) {
            int posicaoAtual = mapa.buscarPosicao(this);

            if (isMembroSociedade) {
                mapa.mover(posicaoAtual, posicaoAtual + 1);
            } else {
                mapa.mover(posicaoAtual, posicaoAtual - 1);
            }
        }
    }

}
