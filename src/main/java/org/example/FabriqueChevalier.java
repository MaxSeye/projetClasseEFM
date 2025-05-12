package org.example;

class FabriqueChevalier {
    public Chevalier creerChevalier(String type, String nom, int pointsDeVie, int puissanceAttaque) {
        if ("pelle".equalsIgnoreCase(type)) {
            return new ChevalierPelle(nom, pointsDeVie, puissanceAttaque);
        } else if ("fantome".equalsIgnoreCase(type)) {
            return new ChevalierFantome(nom, pointsDeVie, puissanceAttaque);
        } else {
            throw new IllegalArgumentException("Type de chevalier inconnu: " + type);
        }
    }
}
