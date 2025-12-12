package fr.troisil.prophetie.modele;

public class Ennemi extends Entite {
    private int degatsAttaque;

    public Ennemi(String nom, int pv, int degatsAttaque) {
        super(nom, pv);
        this.degatsAttaque = degatsAttaque;
    }

    public void attaquer(Entite cible) {
        System.out.println(this.nom + " attaque " + cible.getNom() + " et inflige " + this.degatsAttaque + " degats.");
        cible.recevoirDegats(this.degatsAttaque);
    }
}
