package org.example;

// Implémentation de la scène château
class Chateau extends Scene {
    public Chateau() {
        super("Château");
    }

    @Override
    public void genererEnnemi() {
        FabriqueChevalier fabrique = new FabriqueChevalier();

        // 70% chance de chevalier à la pelle, 30% chance de chevalier fantôme
        if (Math.random() < 0.7) {
            Chevalier chevalier = fabrique.creerChevalier("pelle", "Chevalier du château", 100, 15);
            ajouterEnnemi(chevalier);
            System.out.println("Un chevalier à la pelle apparaît dans le château !");
        } else {
            Chevalier fantome = fabrique.creerChevalier("fantome", "Fantôme du château", 80, 20);
            ajouterEnnemi(fantome);
            System.out.println("Un chevalier fantôme apparaît dans le château !");
        }
    }

    @Override
    public void interagir(Heros heros) {
        super.interagir(heros);
        System.out.println("Vous explorez les salles sombres et les couloirs du château...");
    }
}
