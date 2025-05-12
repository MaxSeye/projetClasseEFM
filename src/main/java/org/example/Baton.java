package org.example;

// Implémentation du bâton
class Baton extends Arme {
    private int bonusMagique;

    public Baton(String nom, int degats, int bonusMagique) {
        super(nom, (degats + bonusMagique) * 10, degats);
        this.bonusMagique = bonusMagique;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println("Attaque au bâton " + this.nom + " pour " + this.degats + " dégâts physiques");
        cible.recevoirAttaque(this.degats);
    }

    @Override
    public void utiliser(Personnage personnage) {
        if (personnage instanceof Heros) {
            ((Heros) personnage).equiper(this);
        } else {
            System.out.println("Seul un héros peut équiper un bâton");
        }
    }

    public int getBonusMagique() {
        return bonusMagique;
    }
}
