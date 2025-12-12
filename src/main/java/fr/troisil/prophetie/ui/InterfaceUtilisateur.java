package fr.troisil.prophetie.ui;

import fr.troisil.prophetie.modele.Direction;
import fr.troisil.prophetie.modele.Joueur;
import java.util.Scanner;

public class InterfaceUtilisateur {
    private Scanner scanner;

    public InterfaceUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMessage(String msg) {
        System.out.println(msg);
    }

    public void afficherSalle(String desc) {
        System.out.println("------------------------------------------------");
        System.out.println("VOUS ETES DANS : " + desc);
        System.out.println("------------------------------------------------");
    }

    public Direction demanderDirection() {
        System.out.println("Quelle direction voulez-vous prendre ? (NORD, SUD, EST, OUEST)");
        while (true) {
            System.out.print("> ");
            String entree = scanner.nextLine().toUpperCase();
            try {
                return Direction.valueOf(entree);
            } catch (IllegalArgumentException e) {
                System.out.println("Direction invalide. Essayez NORD, SUD, EST ou OUEST.");
            }
        }
    }

    public String demanderActionCombat() {
        System.out.println("Que voulez-vous faire ? (ATTAQUER, SOIGNER)");
        while (true) {
            System.out.print("> ");
            String entree = scanner.nextLine().toUpperCase();
            if (entree.equals("ATTAQUER") || entree.equals("SOIGNER")) {
                return entree;
            }
            System.out.println("Action invalide. Tapez ATTAQUER ou SOIGNER.");
        }
    }

    public String demanderReponseEnigme() {
        System.out.print("Veuillez saisir votre reponse : ");
        return scanner.nextLine().trim();
    }

    public void afficherEtatJoueur(Joueur j) {
        System.out.println("Etat du Joueur [" + j.getNom() + "] : " + j.getPv() + " PV / " + j.estVivant());
    }

    public void afficherGameOver(boolean victoire) {
        System.out.println("================================================");
        if (victoire) {
            System.out.println("FELICITATIONS ! Vous avez gagne !");
        } else {
            System.out.println("GAME OVER... Vous etes mort.");
        }
        System.out.println("================================================");
    }
}
