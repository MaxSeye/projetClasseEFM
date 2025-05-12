package org.example;

class EtatBlesse implements EtatHeros {
    @Override
    public void gererCombat(Heros heros, Ennemi ennemi) {
        System.out.println(heros.getNom() + " est blessé mais continue de combattre.");
        // Pas de bonus ni de malus
        ennemi.recevoirAttaque(heros.getArme().getDegats());
    }

    @Override
    public void gererDeplacement(Heros heros) {
        System.out.println(heros.getNom() + " se déplace plus lentement car il est blessé.");
    }
}