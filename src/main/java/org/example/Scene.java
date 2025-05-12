package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Scene {
    protected String nom;
    protected List<Ennemi> ennemis;
    protected List<PNJ> pnjs;

    public Scene(String nom) {
        this.nom = nom;
        this.ennemis = new ArrayList<>();
        this.pnjs = new ArrayList<>();
    }

    public abstract void genererEnnemi();

    public void interagir(Heros heros) {
        System.out.println(heros.getNom() + " explore " + this.nom);
    }

    public void ajouterPNJ(PNJ pnj) {
        this.pnjs.add(pnj);
    }

    public void ajouterEnnemi(Ennemi ennemi) {
        this.ennemis.add(ennemi);
    }

    public String getNom() {
        return nom;
    }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    public List<PNJ> getPNJs() {
        return pnjs;
    }
}
