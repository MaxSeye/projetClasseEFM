package org.example;

class ChevalierFantome extends Chevalier {
    private boolean vulnerableALaMagie;

    public ChevalierFantome(String nom, int pointsDeVie, int puissanceAttaque) {
        super(nom, pointsDeVie, puissanceAttaque);
        this.vulnerableALaMagie = false;
    }

    @Override
    public void attaqueSpeciale(Personnage cible) {
        int degatsSpeciaux = puissanceAttaque + 10;
        System.out.println(this.nom + " effectue une attaque spectrale sur " + cible.getNom() +
                " pour " + degatsSpeciaux + " points de dégâts");
        cible.recevoirAttaque(degatsSpeciaux);
    }

    @Override
    public void attaquer(Personnage cible) {
        // 50% de chance d'utiliser l'attaque spéciale
        if (Math.random() < 0.5) {
            attaqueSpeciale(cible);
        } else {
            super.attaquer(cible);
        }
    }

    @Override
    public void recevoirAttaque(int degats) {
        if (vulnerableALaMagie) {
            super.recevoirAttaque(degats);
        } else {
            System.out.println(this.nom + " est immunisé contre les attaques physiques ! Utilisez une potion magique !");
        }
    }

    public void rendreVulnerable() {
        this.vulnerableALaMagie = true;
        System.out.println(this.nom + " est maintenant vulnérable aux attaques magiques !");
    }
}
