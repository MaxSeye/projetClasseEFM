package org.example;

// Implémentation d'un contact (par exemple, un compagnon)
class Compagnon implements Contact {
    private String nom;

    public Compagnon(String nom) {
        this.nom = nom;
    }

    @Override
    public void miseAJour(Heros heros, String message) {
        System.out.println(nom + " reçoit une mise à jour de " + heros.getNom() + ": " + message);

        // Réagit en fonction de l'état du héros
        if (heros.getPointsDeVie() < 30) {
            System.out.println(nom + " s'inquiète et cherche à aider " + heros.getNom());
        }
    }

    public String getNom() {
        return nom;
    }
}

