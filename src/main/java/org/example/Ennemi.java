package org.example;

// Classe de base pour les ennemis
abstract class Ennemi extends Personnage {
    protected int puissanceAttaque;

    public Ennemi(String nom, int pointsDeVie, int puissanceAttaque) {
        super(nom, pointsDeVie);
        this.puissanceAttaque = puissanceAttaque;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(this.nom + " attaque " + cible.getNom() + " pour " + puissanceAttaque + " points de dégâts");
        cible.recevoirAttaque(puissanceAttaque);
    }

    public abstract void determinerStrategieAttaque();

    // Getter pour puissanceAttaque
    public int getPuissanceAttaque() {
        return puissanceAttaque;
    }
}
