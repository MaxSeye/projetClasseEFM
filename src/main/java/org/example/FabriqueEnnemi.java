package org.example;

// Fabrique pour créer des ennemis
class FabriqueEnnemi implements FabriquePersonnage {
    private String nom;
    private int pointsDeVie;
    private int puissanceAttaque;

    public FabriqueEnnemi(String nom, int pointsDeVie, int puissanceAttaque) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.puissanceAttaque = puissanceAttaque;
    }

    @Override
    public Personnage creerPersonnage() {
        // Crée un ennemi anonyme (à étendre pour des types spécifiques)
        return new Ennemi(nom, pointsDeVie, puissanceAttaque) {
            @Override
            public void determinerStrategieAttaque() {
                System.out.println(this.nom + " utilise une stratégie d'attaque standard");
            }
        };
    }
}