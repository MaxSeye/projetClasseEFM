package org.example;

// Implémentation de la potion magique
class PotionMagique extends Potion {
    public PotionMagique(String nom, int puissance) {
        super(nom, puissance * 8, puissance);
    }

    @Override
    public void consommer(Heros heros) {
        System.out.println(heros.getNom() + " consomme une potion magique et peut maintenant attaquer les ennemis fantômes");
        // Change la stratégie de combat en stratégie magique
        heros.setStrategieCombat(new StrategieMagique());
    }
}
