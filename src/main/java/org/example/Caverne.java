package org.example;

// Implémentation de la scène caverne
class Caverne extends Scene {
    public Caverne() {
        super("Caverne");
    }

    @Override
    public void genererEnnemi() {
        FabriqueChevalier fabrique = new FabriqueChevalier();

        // 50% chance de chevalier à la pelle, 50% chance de chevalier fantôme
        if (Math.random() < 0.5) {
            Chevalier chevalier = fabrique.creerChevalier("pelle", "Gardien de la caverne", 90, 12);
            ajouterEnnemi(chevalier);
            System.out.println("Un gardien de la caverne apparaît !");
        } else {
            Chevalier fantome = fabrique.creerChevalier("fantome", "Esprit des profondeurs", 70, 25);
            ajouterEnnemi(fantome);
            System.out.println("Un esprit des profondeurs apparaît dans la caverne !");
        }
    }

    @Override
    public void interagir(Heros heros) {
        super.interagir(heros);
        System.out.println("Vous explorez les passages étroits et humides de la caverne...");
    }
}