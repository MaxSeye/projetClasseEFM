package org.example;

class EtatAffaibli implements EtatHeros {
    @Override
    public void gererCombat(Heros heros, Ennemi ennemi) {
        System.out.println(heros.getNom() + " est très affaibli et a du mal à attaquer !");
        // Malus de 30% aux dégâts
        int degatsReduits = (int)(heros.getArme().getDegats() * 0.7);
        ennemi.recevoirAttaque(degatsReduits);
    }

    @Override
    public void gererDeplacement(Heros heros) {
        System.out.println(heros.getNom() + " se déplace très lentement car il est gravement affaibli.");
    }
}
