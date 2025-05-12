package org.example;

// Feuille du Composite : objet simple
class ObjetSimple implements ComposantObjet {
    private String nom;
    private int valeur;
    private String description;

    public ObjetSimple(String nom, int valeur, String description) {
        this.nom = nom;
        this.valeur = valeur;
        this.description = description;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getValeur() {
        return valeur;
    }

    @Override
    public void afficherDescription() {
        System.out.println(nom + " (valeur: " + valeur + "): " + description);
    }
}