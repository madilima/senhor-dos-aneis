package com.project;

public abstract class Guerreiro extends Personagem {
    protected Guerreiro(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }

    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        Sociedade sociedade = new Sociedade();
        boolean isMembroSociedade = sociedade.isMembroSociedade(this.getClass());

        int minhaPosicao = mapa.buscarPosicao(this);

        int posicaoDoPersonagemProximo = isMembroSociedade ? (minhaPosicao + 1) : minhaPosicao - 1;

        Personagem personagemProximo = mapa.buscarCasa(posicaoDoPersonagemProximo);

        if (personagemProximo == null) {
            return;
        }

        boolean isPersonagemProximoMembroSociedade = new Sociedade().isMembroSociedade(personagemProximo.getClass());

        if ((isMembroSociedade && !isPersonagemProximoMembroSociedade) || (!isMembroSociedade && isPersonagemProximoMembroSociedade)) {
            int constituicao = personagemProximo.getConstituicao() - (this.getForca() * 2);

            if (constituicao < 0) {
                constituicao = 0;
            }

            personagemProximo.setConstituicao(constituicao);
        }
    }

    public void mover(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        boolean isMembroSociedade = new Sociedade().isMembroSociedade(this.getClass());

        int posicao = mapa.buscarPosicao(this);

        if (isMembroSociedade) {
            mapa.mover(posicao, posicao + 1);
        } else {
            mapa.mover(posicao, posicao - 1);
        }
    }

}
