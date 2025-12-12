package fr.troisil.prophetie.modele;

import fr.troisil.prophetie.ui.InterfaceUtilisateur;

public class SalleEnigme extends Salle {
    private String question;
    private String reponseAttendue;
    private int degatsEchec;

    public SalleEnigme(String description, String question, String reponseAttendue, int degatsEchec) {
        super(description);
        this.question = question;
        this.reponseAttendue = reponseAttendue;
        this.degatsEchec = degatsEchec;
    }

    @Override
    public void explorer(Joueur j, InterfaceUtilisateur ui) {
        ui.afficherMessage("Une enigme vous barre la route !");
        ui.afficherMessage("Question : " + this.question);

        boolean reponseCorrecte = false;
        while (!reponseCorrecte && j.estVivant()) {
            String reponseJoueur = ui.demanderReponseEnigme();

            if (reponseJoueur.equalsIgnoreCase(this.reponseAttendue)) {
                ui.afficherMessage("Bonne reponse ! Vous pouvez passer.");
                reponseCorrecte = true;
            } else {
                ui.afficherMessage("Mauvaise reponse ! Vous subissez " + this.degatsEchec + " degats.");
                j.recevoirDegats(this.degatsEchec);
                ui.afficherEtatJoueur(j);
            }
        }
        this.estVisitee = true;
    }
}
