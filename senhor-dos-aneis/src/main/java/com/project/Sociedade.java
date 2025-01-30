package com.project;

public class Sociedade {
    private Class[] membros;

    public Sociedade() {
        this.membros = new Class[]{
                Gandalf.class,
                Aragorn.class,
                Legolas.class,
        };
    }

    boolean isMembroSociedade(Class<? extends Personagem> membro) {
        for (int i = 0; i < membros.length; i++) {
            if (membros[i].equals(membro)) {
                return true;
            }
        }
        return false;
    }
}
