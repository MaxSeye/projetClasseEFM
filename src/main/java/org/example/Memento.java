package org.example;

// Classe Memento pour sauvegarder l'état du héros
class Memento {
    private EtatHeros etat;
    private int pointsDeVie;
    private ConteneurObjets inventaire;
    private Arme armeEquipee;
    private ComposantArmure armureEquipee;

    public Memento(EtatHeros etat, int pointsDeVie, ConteneurObjets inventaire,
                   Arme armeEquipee, ComposantArmure armureEquipee) {
        this.etat = etat;
        this.pointsDeVie = pointsDeVie;
        this.inventaire = inventaire;
        this.armeEquipee = armeEquipee;
        this.armureEquipee = armureEquipee;
    }

    // Getters pour récupérer l'état sauvegardé
    public EtatHeros getEtat() {
        return etat;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public ConteneurObjets getInventaire() {
        return inventaire;
    }

    public Arme getArmeEquipee() {
        return armeEquipee;
    }

    public ComposantArmure getArmureEquipee() {
        return armureEquipee;
    }
}
