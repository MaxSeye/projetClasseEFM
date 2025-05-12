package org.example;

abstract class Potion extends Objet {
    protected int puissance;

    public Potion(String nom, int valeur, int puissance) {
        super(nom, valeur);
        this.puissance = puissance;
    }

    public abstract void consommer(Heros heros);

    @Override
    public void utiliser(Personnage personnage) {
        if (personnage instanceof Heros) {
            consommer((Heros) personnage);
        } else {
            System.out.println("Seul un héros peut consommer une potion");
        }
    }
}
