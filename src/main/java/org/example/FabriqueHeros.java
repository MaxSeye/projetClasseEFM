package org.example;

class FabriqueHeros implements FabriquePersonnage {
    private String nom;
    private int pointsDeVie;

    public FabriqueHeros(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
    }
    @Override
    public Personnage creerPersonnage() {
        Heros heros = new Heros(nom, pointsDeVie);
        // Initialisation standard d'un héros
        heros.equiper(new Epee("Épée basique", 10));
        heros.equiper(new ArmureBase(5));
        return heros;
    }
}
