package org.example;

// Implémentation de la potion de santé
class PotionSante extends Potion {
    public PotionSante(String nom, int puissance) {
        super(nom, puissance * 5, puissance);
    }

    @Override
    public void consommer(Heros heros) {
        System.out.println(heros.getNom() + " consomme une potion de santé et récupère " + puissance + " points de vie");
        heros.setPointsDeVie(heros.getPointsDeVie() + puissance);
        heros.verifierEtat();
    }
}
