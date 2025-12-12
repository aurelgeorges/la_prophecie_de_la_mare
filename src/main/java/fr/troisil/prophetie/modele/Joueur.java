package fr.troisil.prophetie.modele;

public class Joueur extends Entite {
    private int potions;

    public Joueur(String nom, int pv) {
        super(nom, pv);
        this.potions = 1; // On donne une potion par défaut pour l'exemple
    }

    public void soigner(int montant) {
        if (potions > 0) {
            this.pv += montant;
            if (this.pv > this.pvMax) {
                this.pv = this.pvMax;
            }
            this.potions--;
            System.out.println(
                    this.nom + " se soigne et recupere " + montant + " PV. (Potions restantes : " + this.potions + ")");
        } else {
            System.out.println(this.nom + " n'a plus de potions !");
        }
    }

    public void attaquer(Entite cible) {
        // Dégâts fixes pour simplifier
        int degats = 10;
        System.out.println(this.nom + " attaque " + cible.getNom() + " et inflige " + degats + " degats.");
        cible.recevoirDegats(degats);
    }
}
