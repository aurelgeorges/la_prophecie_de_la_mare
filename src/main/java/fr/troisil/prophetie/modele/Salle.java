package fr.troisil.prophetie.modele;

import fr.troisil.prophetie.ui.InterfaceUtilisateur;

public abstract class Salle {
    protected String description;
    protected boolean estVisitee;

    public Salle(String description) {
        this.description = description;
        this.estVisitee = false;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract void explorer(Joueur j, InterfaceUtilisateur ui);
}
