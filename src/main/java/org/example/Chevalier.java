package org.example;

abstract class Chevalier extends Ennemi {
    public Chevalier(String nom, int pointsDeVie, int puissanceAttaque) {
        super(nom, pointsDeVie, puissanceAttaque);
    }

    public abstract void attaqueSpeciale(Personnage cible);

    @Override
    public void determinerStrategieAttaque() {
        // Logique commune aux chevaliers
        System.out.println(this.nom + " prépare sa stratégie d'attaque");
    }
}

// Implémentation d'un chevalier à la pelle
class ChevalierPelle extends Chevalier {
    public ChevalierPelle(String nom, int pointsDeVie, int puissanceAttaque) {
        super(nom, pointsDeVie, puissanceAttaque);
    }

    @Override
    public void attaqueSpeciale(Personnage cible) {
        int degatsSpeciaux = puissanceAttaque * 2;
        System.out.println(this.nom + " effectue une attaque spéciale à la pelle sur " + cible.getNom() +
                " pour " + degatsSpeciaux + " points de dégâts");
        cible.recevoirAttaque(degatsSpeciaux);
    }

    @Override
    public void attaquer(Personnage cible) {
        // 30% de chance d'utiliser l'attaque spéciale
        if (Math.random() < 0.3) {
            attaqueSpeciale(cible);
        } else {
            super.attaquer(cible);
        }
    }
}
