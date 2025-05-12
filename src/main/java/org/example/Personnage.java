package org.example;

// Classe abstraite de base pour tous les personnages
abstract class Personnage {
    protected String nom;
    protected int pointsDeVie;

    public Personnage(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
    }

    public abstract void attaquer(Personnage cible);

    public void recevoirAttaque(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
        }
        System.out.println(this.nom + " reçoit " + degats + " points de dégâts. Points de vie restants: " + this.pointsDeVie);
    }

    public void interagir(PNJ pnj) {
        System.out.println(this.nom + " interagit avec " + pnj.getNom());
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}