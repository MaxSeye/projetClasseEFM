package org.example;

// Stratégie de combat magique
class StrategieMagique implements StrategieCombat {
    @Override
    public void executer(Personnage attaquant, Personnage cible) {
        if (attaquant instanceof Heros) {
            Heros heros = (Heros) attaquant;

            // Vérifie si la cible est un chevalier fantôme
            if (cible instanceof ChevalierFantome) {
                ChevalierFantome fantome = (ChevalierFantome) cible;
                fantome.rendreVulnerable();
                System.out.println(heros.getNom() + " utilise une attaque magique contre " + cible.getNom());
                cible.recevoirAttaque(20); // Dégâts magiques standards
            } else {
                System.out.println(heros.getNom() + " utilise une attaque magique contre " + cible.getNom());
                cible.recevoirAttaque(15); // Dégâts magiques standards contre cible normale
            }
        } else {
            // Logique par défaut pour les non-héros
            System.out.println(attaquant.getNom() + " lance un sort sur " + cible.getNom());
            cible.recevoirAttaque(15); // Dégâts par défaut
        }
    }
}
