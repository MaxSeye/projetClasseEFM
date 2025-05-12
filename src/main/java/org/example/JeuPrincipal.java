package org.example;

// Exemple d'utilisation
public class JeuPrincipal {
    public static void main(String[] args) {
        // Création d'une nouvelle instance
        JeuRolePeaux jeu = new JeuRolePeaux("Pape");
        jeu.demarrer();

        // Exemple d'interactions
        System.out.println("\n=== DÉMONSTRATION DES PATTERNS ===");

        // Pattern État
//        Récupère le héros joueur
//        Modifie ses points de vie à 75 (état "blessé")
//        Vérifie et affiche son état actuel (sain, blessé ou mourant)

        System.out.println("\n[PATTERN ÉTAT]");
        Heros heros = jeu.getJoueur();
        heros.setPointsDeVie(75); // Blessé
        heros.verifierEtat();

        // Pattern Décorateur
//        Crée une armure de base avec 5 points de défense
//        Ajoute une couche de bronze (décorateur)
//        Ajoute ensuite des couches d'argent et d'or (décorateurs imbriqués)
//        Équipe le héros avec cette armure complète

        System.out.println("\n[PATTERN DÉCORATEUR]");
        ComposantArmure armureBase = new ArmureBase(5);
        System.out.println("Défense armure de base: " + armureBase.getDefense());

        ComposantArmure armureBronze = new ArmureBronze(armureBase);
        System.out.println("Défense armure de bronze: " + armureBronze.getDefense());

        ComposantArmure armureComplete = new ArmureOr(new ArmureArgent(armureBronze));
        System.out.println("Défense armure complète: " + armureComplete.getDefense());

        heros.equiper(armureComplete);

//        Récupère l'inventaire (sac) du héros
//
//        Ajoute des objets simples directement dans le sac
//
//        Crée un conteneur (coffret) qui contient des potions
//
//        Ajoute le coffret dans le sac
//
//        Affiche la description de tout le contenu (y compris les objets imbriqués)
        // Pattern Composite
        System.out.println("\n[PATTERN COMPOSITE]");
        ConteneurObjets sac = heros.getInventaire();
        sac.ajouter(new ObjetSimple("Carte au trésor", 15, "Indique l'emplacement d'un trésor"));
        sac.ajouter(new ObjetSimple("Boussole", 5, "Indique toujours le nord"));

        ConteneurObjets coffret = new ConteneurObjets("Coffret à potions");
        coffret.ajouter(new ObjetSimple("Potion de vie", 20, "Restaure 50 points de vie"));
        coffret.ajouter(new ObjetSimple("Potion de force", 25, "Augmente temporairement la force"));

        sac.ajouter(coffret);
        sac.afficherDescription();

        //Change la stratégie de combat du héros pour une stratégie de corps-à-corps
        // Pattern Stratégie
        System.out.println("\n[PATTERN STRATÉGIE]");
        heros.setStrategieCombat(new StrategieCorpsACorps());
        System.out.println("Stratégie changée: Corps à corps");

        // Sauvegarder l'état actuel
        System.out.println("\n[PATTERN MEMENTO]");
        Memento sauvegarde = heros.sauvegarderEtat();

        // Changer l'état
        heros.setPointsDeVie(20);
        heros.verifierEtat();
        System.out.println("État actuel: " + heros.getEtatActuel().getClass().getSimpleName());

        // Restaurer l'état
        heros.restaurerEtat(sauvegarde);
        System.out.println("État restauré: " + heros.getEtatActuel().getClass().getSimpleName());


//        Crée deux contacts (un compagnon et un mage distant)
//
//        Les ajoute comme observateurs du héros
//
//        Notifie tous les contacts (ils réagiront à la notification)
        // Pattern Observateur

        System.out.println("\n[PATTERN OBSERVATEUR]");
        Compagnon compagnon = new Compagnon("Lydia");
        heros.ajouterContact(compagnon);

        ContactDistant mage = new ContactDistant("Gandalf", "Tour des mages");
        heros.ajouterContact(mage);

        heros.notifierContacts();

        // Combat dans la scène actuelle
        //Lance un combat dans la scène actuelle du jeu
        System.out.println("\n[DÉMO COMBAT]");
        jeu.combattre();

        System.out.println("\nDémonstration terminée !");
    }
}