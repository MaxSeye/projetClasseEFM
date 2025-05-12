package org.example;

class StrategieCorpsACorps implements StrategieCombat {
    @Override
    public void executer(Personnage attaquant, Personnage cible) {
        if (attaquant instanceof Heros) {
            Heros heros = (Heros) attaquant;
            Arme arme = heros.getArme();
            if (arme instanceof Epee || arme instanceof Baton) {
                System.out.println(heros.getNom() + " attaque " + cible.getNom() + " avec " + arme.getNom());
                cible.recevoirAttaque(arme.getDegats());
            } else {
                System.out.println(heros.getNom() + " n'a pas d'arme de corps à corps équipée !");
            }
        } else {
            // Logique par défaut pour les non-héros
            System.out.println(attaquant.getNom() + " attaque " + cible.getNom());
            cible.recevoirAttaque(10); // Dégâts par défaut
        }
    }
}
