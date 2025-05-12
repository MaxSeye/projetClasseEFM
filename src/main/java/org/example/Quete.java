package org.example;

import java.util.ArrayList;
import java.util.List;

// Classe pour les quêtes
class Quete {
    private String titre;
    private String description;
    private int recompensePieces;
    private List<ComposantObjet> recompenseObjets;
    private boolean completee;

    public Quete(String titre, String description, int recompensePieces) {
        this.titre = titre;
        this.description = description;
        this.recompensePieces = recompensePieces;
        this.recompenseObjets = new ArrayList<>();
        this.completee = false;
    }

    public void ajouterRecompenseObjet(ComposantObjet objet) {
        recompenseObjets.add(objet);
    }

    public void completer(Heros heros) {
        if (!completee) {
            System.out.println(heros.getNom() + " a complété la quête: " + titre);
            System.out.println("Récompense: " + recompensePieces + " pièces d'or");

            // Ajout des objets à l'inventaire du héros
            for (ComposantObjet objet : recompenseObjets) {
                heros.ajouterObjet(objet);
                System.out.println("Objet reçu: " + objet.getNom());
            }

            completee = true;
        } else {
            System.out.println("Cette quête a déjà été complétée.");
        }
    }

    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public boolean estCompletee() {
        return completee;
    }
}

