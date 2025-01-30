package com.project;

import java.util.ArrayList;

public class Simulador {
    private Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() throws PersonagemNaoEncontradoNoMapaException {
        while (true) {
            ArrayList<Personagem> personagensQueJaAtacaram = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Personagem p = mapa.buscarCasa(i);

                if (p == null || personagensQueJaAtacaram.contains(p)) {
                    continue;
                }

                p.atacar(mapa);
                p.mover(mapa);

                personagensQueJaAtacaram.add(p);
            }

            if (checkVitoriaSociedade()) {
                break;
            }

            if (checkVitoriaSauron()) {
                throw new SauronDominaOMundoException("A humanidade sofre perante a tirania de Sauron.");
            }
        }
    }

    private boolean checkVitoriaSociedade() {
        boolean existeInimigo = false;

        for (int i = 0; i < 10; i++) {
            Personagem p = mapa.buscarCasa(i);

            if (p == null) {
                continue;
            }

            if (!new Sociedade().isMembroSociedade(p.getClass())) {
                existeInimigo = true;
            }
        }

        if (existeInimigo) {
            return false;
        }

        Personagem personagem = mapa.buscarCasa(9);

        return personagem != null;
    }

    private boolean checkVitoriaSauron() {
        boolean existeMembroSociedade = false;

        for (int i = 0; i < 10; i++) {
            Personagem p = mapa.buscarCasa(i);

            if (p == null) {
                continue;
            }

            if (new Sociedade().isMembroSociedade(p.getClass())) {
                existeMembroSociedade = true;
            }
        }

        return !existeMembroSociedade;
    }
}
