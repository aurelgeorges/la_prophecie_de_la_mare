package fr.troisil.prophetie.modele;

public abstract class Entite {
    protected String nom;
    protected int pv;
    protected int pvMax;

    public Entite(String nom, int pv) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
    }

    public void recevoirDegats(int montant) {
        this.pv -= montant;
        if (this.pv < 0) {
            this.pv = 0;
        }
    }

    public boolean estVivant() {
        return this.pv > 0;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPv() {
        return this.pv;
    }
}
