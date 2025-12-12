package fr.troisil.prophetie.modele;

import fr.troisil.prophetie.ui.InterfaceUtilisateur;

public class SalleTresor extends Salle {
    private String contenu;
    private boolean estOuvert;

    public SalleTresor(String description, String contenu) {
        super(description);
        this.contenu = contenu;
        this.estOuvert = false;
    }

    @Override
    public void explorer(Joueur j, InterfaceUtilisateur ui) {
        if (!estOuvert) {
            ui.afficherMessage("Vous trouvez un coffre !");
            ui.afficherMessage("Vous l'ouvrez et trouvez : " + this.contenu);
            this.estOuvert = true;
            j.soigner(1000);
            ui.afficherMessage("Vous vous sentez revigore !");
        } else {
            ui.afficherMessage("Le coffre est deja vide.");
        }
        this.estVisitee = true;
    }
}
