package com.project;

import org.junit.Assert;
import org.junit.Test;


public class SimuladorTest {

    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim()
            throws com.project.PersonagemJaEstaNoMapaException, com.project.PosicaoOcupadaException, com.project.SauronDominaOMundoException, com.project.PersonagemNaoEncontradoNoMapaException {
        // Início:  "|A|L| | | | | |O| |M|"
        String resultadoEsperado = "| | | | |A| | | | |L|";

        com.project.Aragorn aragorn = new com.project.Aragorn();
        com.project.Legolas legolas = new com.project.Legolas();
        com.project.Orc orc = new com.project.Orc();
        com.project.Goblim goblim = new com.project.Goblim();
        com.project.Mapa mapa = new com.project.Mapa();
        com.project.Simulador simulador = new com.project.Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expected = com.project.SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
            throws com.project.PersonagemJaEstaNoMapaException, com.project.PosicaoOcupadaException, com.project.SauronDominaOMundoException, com.project.PersonagemNaoEncontradoNoMapaException {
        // Início: "|A| |I| | | | |U|O|M|"
        // Fim:    "| | | | | | |O|M| | |"

        com.project.Aragorn aragorn = new com.project.Aragorn();
        com.project.Gimli gimli = new com.project.Gimli();
        com.project.Urukhai urukhai = new com.project.Urukhai();
        com.project.Orc orc = new com.project.Orc();
        com.project.Goblim goblim = new com.project.Goblim();
        com.project.Mapa mapa = new com.project.Mapa();
        com.project.Simulador simulador = new com.project.Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(2, gimli);
        mapa.inserir(7, urukhai);
        mapa.inserir(8, orc);
        mapa.inserir(9, goblim);
        simulador.simular();
    }

    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
            throws com.project.PersonagemJaEstaNoMapaException, com.project.PosicaoOcupadaException, com.project.SauronDominaOMundoException, com.project.PersonagemNaoEncontradoNoMapaException {
        // Início:  "|G| | | | | | | | |S|"
        String resultadoEsperado = "| | | | | | | | | |G|";

        com.project.Gandalf gandalf = new com.project.Gandalf();
        com.project.Saruman saruman = new com.project.Saruman();
        com.project.Mapa mapa = new com.project.Mapa();
        com.project.Simulador simulador = new com.project.Simulador(mapa);

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    @Test(expected = com.project.SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
            throws com.project.PersonagemJaEstaNoMapaException, com.project.PosicaoOcupadaException, com.project.SauronDominaOMundoException, com.project.PersonagemNaoEncontradoNoMapaException {
        // Início:  "|L| | | | | | | |U|O|"
        // Fim:     "| | | | | |U| | | | |";

        com.project.Legolas legolas = new com.project.Legolas();
        com.project.Orc orc = new com.project.Orc();
        com.project.Urukhai urukhai = new com.project.Urukhai();
        com.project.Mapa mapa = new com.project.Mapa();
        com.project.Simulador simulador = new com.project.Simulador(mapa);

        mapa.inserir(0, legolas);
        mapa.inserir(8, urukhai);
        mapa.inserir(9, orc);
        simulador.simular();
    }

    @Test(expected = com.project.SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai()
            throws com.project.PersonagemJaEstaNoMapaException, com.project.PosicaoOcupadaException, com.project.SauronDominaOMundoException, com.project.PersonagemNaoEncontradoNoMapaException {
        // Início:  "|B| | | | | | | | |U|"
        // Fim:     "| | | | |U| | | | | |";

        com.project.Boromir boromir = new com.project.Boromir();
        com.project.Urukhai urukhai = new com.project.Urukhai();
        com.project.Mapa mapa = new com.project.Mapa();
        com.project.Simulador simulador = new com.project.Simulador(mapa);

        mapa.inserir(0, boromir);
        mapa.inserir(9, urukhai);
        simulador.simular();
    }

}
