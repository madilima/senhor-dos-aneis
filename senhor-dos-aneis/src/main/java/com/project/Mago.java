package com.project;

import java.util.Objects;

public abstract class Mago extends Personagem {
    protected Mago(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }

    public void atacar(Mapa mapa) {
        boolean isMembroSociedade = new Sociedade().isMembroSociedade(this.getClass());
        for (Personagem personagem : mapa.getPersonagem()) {
            if (personagem == null) {
                continue;
            }
            boolean isPersonagemMembroSociedade = new Sociedade().isMembroSociedade(personagem.getClass());
            if ((isMembroSociedade && !isPersonagemMembroSociedade) || (!isMembroSociedade && isPersonagemMembroSociedade)) {
                int constituicao = personagem.getConstituicao() - this.getInteligencia();

                if (constituicao < 0) {
                    constituicao = 0;
                }

                personagem.setConstituicao(constituicao);
            }
        }

    }

    public void mover(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        boolean existePersonagensNoMapa = false;

        for (int i = 0; i < 10; i++) {
            Personagem p = mapa.buscarCasa(i);

            if (p == null || Objects.equals(p.toString(), this.toString())) {
                continue;
            }

            existePersonagensNoMapa = true;
        }

        if (existePersonagensNoMapa) {
            return;
        }

        boolean isMembroSociedade = new Sociedade().isMembroSociedade(this.getClass());

        if (isMembroSociedade) {
            mapa.mover(mapa.buscarPosicao(this), mapa.buscarPosicao(this) + 1);
        } else {
            mapa.mover(mapa.buscarPosicao(this), mapa.buscarPosicao(this) - 1);
        }
    }

}
