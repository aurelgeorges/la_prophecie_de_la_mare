package fr.troisil.prophetie.core;

import fr.troisil.prophetie.modele.*;
import fr.troisil.prophetie.ui.InterfaceUtilisateur;
import java.util.ArrayList;
import java.util.List;

public class Jeu {
    private boolean estFini;
    private Direction directionPrecedente;
    private List<Salle> listeSalle;
    private Joueur joueur;
    private InterfaceUtilisateur ui;

    public Jeu() {
        this.estFini = false;
        this.listeSalle = new ArrayList<>();
        this.ui = new InterfaceUtilisateur();
        this.joueur = new Joueur("Heros", 100);

        Salle salle1 = new SalleTresor("Halle d'entree sombre et humide. Rien a signaler.", "Poussiere");

        Ennemi gobelin = new Ennemi("Gobelin", 30, 5);
        Salle salle2 = new SalleCombat("Couloir etroit infesté de bruits.", gobelin);

        Salle salle3 = new SalleEnigme("Une porte gardee par une statue parlante.",
                "Qu'est-ce qui a des racines que personne ne voit, Qui est plus grand que les arbres, Qui monte, qui monte, et pourtant ne pousse jamais ?",
                "MONTAGNE",
                15);

        Salle salle4 = new SalleTresor("Chambre royale aux murs dores.", "La Prophétie Perdue");

        this.listeSalle.add(salle1);
        this.listeSalle.add(salle2);
        this.listeSalle.add(salle3);
        this.listeSalle.add(salle4);
    }

    public void lancer() {
        ui.afficherMessage("Bienvenue dans LA PROPHETIE DE LA MARE !");
        boucleDeJeu();
    }

    public void boucleDeJeu() {
        int indexSalle = 0;

        while (!estFini && indexSalle < listeSalle.size()) {
            Salle salleCourante = listeSalle.get(indexSalle);

            ui.afficherSalle(salleCourante.getDescription());
            salleCourante.explorer(joueur, ui);

            if (!joueur.estVivant()) {
                estFini = true;
                ui.afficherGameOver(false);
                break;
            }

            if (indexSalle == listeSalle.size() - 1) {
                estFini = true;
                ui.afficherGameOver(true);
                break;
            }

            this.directionPrecedente = ui.demanderDirection();
            ui.afficherMessage("Vous allez vers le " + this.directionPrecedente + "...");

            indexSalle++;
        }
    }
}
