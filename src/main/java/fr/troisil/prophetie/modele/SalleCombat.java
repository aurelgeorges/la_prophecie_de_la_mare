package fr.troisil.prophetie.modele;

import fr.troisil.prophetie.ui.InterfaceUtilisateur;

public class SalleCombat extends Salle {
    private Ennemi ennemi;

    public SalleCombat(String description, Ennemi ennemi) {
        super(description);
        this.ennemi = ennemi;
    }

    @Override
    public void explorer(Joueur j, InterfaceUtilisateur ui) {
        ui.afficherMessage("Un ennemi apparait : " + ennemi.getNom() + " !");

        while (j.estVivant() && ennemi.estVivant()) {
            this.gererTourCombat(j, ui);
        }

        if (j.estVivant()) {
            ui.afficherMessage("Vous avez vaincu " + ennemi.getNom() + " !");
            this.estVisitee = true;
        }
    }

    private void gererTourCombat(Joueur j, InterfaceUtilisateur ui) {
        // Tour du joueur
        ui.afficherEtatJoueur(j);
        String action = ui.demanderActionCombat();

        if (action.equals("ATTAQUER")) {
            j.attaquer(ennemi);
        } else if (action.equals("SOIGNER")) {
            j.soigner(20);
        }

        // Tour de l'ennemi (si vivant)
        if (ennemi.estVivant()) {
            ennemi.attaquer(j);
        }
    }
}
