package org.example;

import java.util.ArrayList;
import java.util.List;

// Classe pour les personnages non-joueurs
class PNJ extends Personnage {
    private List<Quete> quetesDisponibles;

    public PNJ(String nom) {
        super(nom, 100); // PNJ standard avec 100 points de vie
        this.quetesDisponibles = new ArrayList<>();
    }

    @Override
    public void attaquer(Personnage cible) {
        // Les PNJ n'attaquent pas
        System.out.println(this.nom + " est un PNJ pacifique et n'attaque pas.");
    }

    public void proposerQuete(Heros heros) {
        if (!quetesDisponibles.isEmpty()) {
            Quete quete = quetesDisponibles.get(0);
            System.out.println(this.nom + " propose une quête à " + heros.getNom() + ": " + quete.getDescription());
        } else {
            System.out.println(this.nom + " n'a pas de quête disponible pour le moment.");
        }
    }

    public void donnerInformation(Heros heros) {
        System.out.println(this.nom + " partage une information avec " + heros.getNom());
    }

    public void ajouterQuete(Quete quete) {
        this.quetesDisponibles.add(quete);
    }

    public List<Quete> getQuetesDisponibles() {
        return quetesDisponibles;
    }
}
