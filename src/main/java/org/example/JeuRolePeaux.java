package org.example;

import java.util.ArrayList;
import java.util.List;

//Classe principale pour le jeu
class JeuRolePeaux {
    private Heros joueur;
    private List<Scene> scenes;
    private Scene sceneActuelle;

    public JeuRolePeaux(String nomJoueur) {
        // Création du héros
        FabriqueHeros fabriqueHeros = new FabriqueHeros(nomJoueur, 100);
        this.joueur = (Heros) fabriqueHeros.creerPersonnage();

        // Initialisation des scènes
        this.scenes = new ArrayList<>();
        scenes.add(new Chateau());
        scenes.add(new Caverne());
        scenes.add(new Bois());

        // Début du jeu au château
        this.sceneActuelle = scenes.get(0);
    }

    public void demarrer() {
        System.out.println("=== JEU DE ROLE-PEAUX ===");
        System.out.println("Bienvenue, " + joueur.getNom() + " !");
        System.out.println("Votre aventure commence...");

        // Initialisation des PNJ
        initialiserPNJs();

        // Le héros explore la scène actuelle
        sceneActuelle.interagir(joueur);
        sceneActuelle.genererEnnemi();
    }

    private void initialiserPNJs() {
        // Création des PNJ pour chaque scène

        // Château
        PNJ garde = new PNJ("Garde du château");
        Quete queteGarde = new Quete("Patrouille nocturne",
                "Aidez le garde à patrouiller autour du château", 50);
        queteGarde.ajouterRecompenseObjet(new ObjetSimple("Insigne de garde", 10,
                "Un insigne prouvant votre service en tant que garde"));
        garde.ajouterQuete(queteGarde);
        scenes.get(0).ajouterPNJ(garde);

        // Caverne
        PNJ mineur = new PNJ("Vieux mineur");
        Quete queteMineur = new Quete("Les cristaux perdus",
                "Récupérez les cristaux magiques au fond de la caverne", 80);
        queteMineur.ajouterRecompenseObjet(new ObjetSimple("Cristal magique", 30,
                "Un cristal brillant aux propriétés magiques"));
        mineur.ajouterQuete(queteMineur);
        scenes.get(1).ajouterPNJ(mineur);

        // Bois
        PNJ druide = new PNJ("Druide mystérieux");
        Quete queteDruide = new Quete("Plantes médicinales",
                "Collectez des plantes rares pour le druide", 60);
        queteDruide.ajouterRecompenseObjet(new ObjetSimple("Amulette de protection", 20,
                "Une amulette offrant une protection contre les sortilèges"));
        druide.ajouterQuete(queteDruide);
        scenes.get(2).ajouterPNJ(druide);
    }

    public void changerScene(int indexScene) {
        if (indexScene >= 0 && indexScene < scenes.size()) {
            sceneActuelle = scenes.get(indexScene);
            System.out.println(joueur.getNom() + " se rend à " + sceneActuelle.getNom());
            sceneActuelle.interagir(joueur);
            sceneActuelle.genererEnnemi();
        } else {
            System.out.println("Scène invalide.");
        }
    }

    public void combattre() {
        List<Ennemi> ennemis = sceneActuelle.getEnnemis();
        if (!ennemis.isEmpty()) {
            Ennemi ennemi = ennemis.get(0);
            System.out.println("Un combat débute entre " + joueur.getNom() + " et " + ennemi.getNom());

            // Boucle de combat
            while (joueur.estVivant() && ennemi.estVivant()) {
                // Tour du joueur
                joueur.attaquer(ennemi);
                joueur.notifierContacts();

                // Vérification si l'ennemi est encore vivant
                if (!ennemi.estVivant()) {
                    System.out.println(ennemi.getNom() + " a été vaincu !");
                    ennemis.remove(ennemi);
                    break;
                }

                // Tour de l'ennemi
                ennemi.attaquer(joueur);
                joueur.verifierEtat();

                // Vérification si le joueur est encore vivant
                if (!joueur.estVivant()) {
                    System.out.println(joueur.getNom() + " a été vaincu...");
                    break;
                }
            }
        } else {
            System.out.println("Aucun ennemi à combattre pour le moment.");
        }
    }

    public void interagirAvecPNJ(int indexPNJ) {
        List<PNJ> pnjs = sceneActuelle.getPNJs();
        if (indexPNJ >= 0 && indexPNJ < pnjs.size()) {
            PNJ pnj = pnjs.get(indexPNJ);
            joueur.interagir(pnj);
            pnj.proposerQuete(joueur);
        } else {
            System.out.println("PNJ invalide.");
        }
    }

    // Getters
    public Heros getJoueur() {
        return joueur;
    }

    public Scene getSceneActuelle() {
        return sceneActuelle;
    }

    public List<Scene> getScenes() {
        return scenes;
    }
}
