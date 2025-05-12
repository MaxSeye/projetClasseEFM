package org.example;

// Classe abstraite pour les armes
abstract class Arme extends Objet {
    protected int degats;

    public Arme(String nom, int valeur, int degats) {
        super(nom, valeur);
        this.degats = degats;
    }

    public abstract void attaquer(Personnage cible);

    public int getDegats() {
        return degats;
    }
}
