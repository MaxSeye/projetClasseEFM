package org.example;


import java.util.ArrayList;
import java.util.List;

// Classe pour le personnage principal
class Heros extends Personnage {
    private List<Contact> contacts;
    private ComposantArmure armure;
    private Arme arme;
    private EtatHeros etatActuel;
    private List<Memento> etatsEnregistres;
    private ConteneurObjets inventaire;
    private StrategieCombat strategieCombat;

    public Heros(String nom, int pointsDeVie) {
        super(nom, pointsDeVie);
        this.contacts = new ArrayList<>();
        this.etatsEnregistres = new ArrayList<>();
        this.inventaire = new ConteneurObjets("Sac");
        this.etatActuel = new EtatPleineForme();
    }

    @Override
    public void attaquer(Personnage cible) {
        if (arme != null && strategieCombat != null) {
            System.out.println(this.nom + " attaque " + cible.getNom());
            strategieCombat.executer(this, cible);
        } else {
            System.out.println("Aucune arme équipée ou stratégie définie !");
        }
    }

    public Memento sauvegarderEtat() {
        Memento memento = new Memento(
                this.etatActuel,
                this.pointsDeVie,
                this.inventaire,
                this.arme,
                this.armure
        );
        this.etatsEnregistres.add(memento);
        System.out.println("État du héros sauvegardé");
        return memento;
    }

    public void restaurerEtat(Memento memento) {
        this.etatActuel = memento.getEtat();
        this.pointsDeVie = memento.getPointsDeVie();
        this.inventaire = memento.getInventaire();
        this.arme = memento.getArmeEquipee();
        this.armure = memento.getArmureEquipee();
        System.out.println("État du héros restauré");
    }

    public void notifierContacts() {
        for (Contact contact : contacts) {
            contact.miseAJour(this, "Combat en cours ! Points de vie: " + this.pointsDeVie);
        }
    }

    public void changerEtat(EtatHeros etat) {
        this.etatActuel = etat;
        System.out.println(this.nom + " change d'état: " + etat.getClass().getSimpleName());
    }

    public void verifierEtat() {
        if (this.pointsDeVie > 70) {
            changerEtat(new EtatPleineForme());
        } else if (this.pointsDeVie > 30) {
            changerEtat(new EtatBlesse());
        } else {
            changerEtat(new EtatAffaibli());
        }
    }

    public void equiper(Arme arme) {
        this.arme = arme;
        System.out.println(this.nom + " équipe " + arme.getNom());
    }

    public void equiper(ComposantArmure armure) {
        this.armure = armure;
        System.out.println(this.nom + " équipe " + armure.getClass().getSimpleName());
    }

    public void setStrategieCombat(StrategieCombat strategie) {
        this.strategieCombat = strategie;
    }

    public void ajouterContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void retirerContact(Contact contact) {
        this.contacts.remove(contact);
    }

    public void ajouterObjet(ComposantObjet objet) {
        this.inventaire.ajouter(objet);
    }

    // Getters
    public ComposantArmure getArmure() {
        return armure;
    }

    public Arme getArme() {
        return arme;
    }

    public EtatHeros getEtatActuel() {
        return etatActuel;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public ConteneurObjets getInventaire() {
        return inventaire;
    }
}

