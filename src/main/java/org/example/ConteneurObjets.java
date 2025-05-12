package org.example;

import java.util.ArrayList;
import java.util.List;

//Composite : conteneur d'objets
class ConteneurObjets implements ComposantObjet {
    private String nom;
    private List<ComposantObjet> contenu;

    public ConteneurObjets(String nom) {
        this.nom = nom;
        this.contenu = new ArrayList<>();
    }

    public void ajouter(ComposantObjet objet) {
        contenu.add(objet);
        System.out.println(objet.getNom() + " ajouté à " + this.nom);
    }

    public void retirer(ComposantObjet objet) {
        contenu.remove(objet);
        System.out.println(objet.getNom() + " retiré de " + this.nom);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getValeur() {
        int valeurTotale = 0;
        for (ComposantObjet objet : contenu) {
            valeurTotale += objet.getValeur();
        }
        return valeurTotale;
    }

    @Override
    public void afficherDescription() {
        System.out.println("=== Contenu de " + nom + " ===");
        for (ComposantObjet objet : contenu) {
            objet.afficherDescription();
        }
        System.out.println("Valeur totale: " + getValeur());
    }

    public List<ComposantObjet> getContenu() {
        return contenu;
    }
}
