package org.example;

// Implémentation d'un contact distant (par exemple, un personnage situé ailleurs)
class ContactDistant implements Contact {
    private String nom;
    private String lieu;

    public ContactDistant(String nom, String lieu) {
        this.nom = nom;
        this.lieu = lieu;
    }

    @Override
    public void miseAJour(Heros heros, String message) {
        System.out.println("Message envoyé à " + nom + " à " + lieu + ": " + message);
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }
}