package org.example;

// État de pleine forme
class EtatPleineForme implements EtatHeros {
    @Override
    public void gererCombat(Heros heros, Ennemi ennemi) {
        System.out.println(heros.getNom() + " est en pleine forme et attaque avec toute sa puissance !");
        // Bonus de 20% aux dégâts
        int degatsBonus = (int)(heros.getArme().getDegats() * 1.2);
        ennemi.recevoirAttaque(degatsBonus);
    }

    @Override
    public void gererDeplacement(Heros heros) {
        System.out.println(heros.getNom() + " se déplace normalement.");
    }
}

