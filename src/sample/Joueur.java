package sample;

public class Joueur {
    String nom;
    int id;

    public Joueur(String nom, int id) {
        this.nom = nom;
        this.id  = id;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }

    public int getId(){
        return id;
    }
}