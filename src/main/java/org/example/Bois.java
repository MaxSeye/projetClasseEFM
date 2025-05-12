package org.example;

// Implémentation de la scène bois
class Bois extends Scene {
    public Bois() {
        super("Bois");
    }

    @Override
    public void genererEnnemi() {
        FabriqueChevalier fabrique = new FabriqueChevalier();

        // 80% chance de chevalier à la pelle, 20% chance de chevalier fantôme
        if (Math.random() < 0.8) {
            Chevalier chevalier = fabrique.creerChevalier("pelle", "Patrouilleur des bois", 80, 10);
            ajouterEnnemi(chevalier);
            System.out.println("Un patrouilleur des bois apparaît !");
        } else {
            Chevalier fantome = fabrique.creerChevalier("fantome", "Esprit de la forêt", 60, 18);
            ajouterEnnemi(fantome);
            System.out.println("Un esprit de la forêt apparaît dans les bois !");
        }
    }

    @Override
    public void interagir(Heros heros) {
        super.interagir(heros);
        System.out.println("Vous explorez les sentiers sinueux et les clairières des bois...");
    }
}