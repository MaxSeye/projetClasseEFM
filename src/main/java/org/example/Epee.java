package org.example;

// Implémentation de l'épée
class Epee extends Arme {
    public Epee(String nom, int degats) {
        super(nom, degats * 10, degats); // Valeur = dégâts * 10
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println("Attaque à l'épée " + this.nom + " pour " + this.degats + " dégâts");
        cible.recevoirAttaque(this.degats);
    }

    @Override
    public void utiliser(Personnage personnage) {
        if (personnage instanceof Heros) {
            ((Heros) personnage).equiper(this);
        } else {
            System.out.println("Seul un héros peut équiper une épée");
        }
    }
}
