package org.example;

// Classe abstraite pour tous les objets
abstract class Objet {
    protected String nom;
    protected int valeur;

    public Objet(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
    }

    public abstract void utiliser(Personnage personnage);

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }
}

