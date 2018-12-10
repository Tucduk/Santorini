
public class Joueur {
    String nom;
    int id;
    Hero hero;
    Pouvoir pouvoir;
    private String couleur;


    public Joueur(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public Joueur(String nom, int id, String couleur) {
        this.nom = nom;
        this.id = id;
        this.couleur = couleur;
    }

    public Joueur(String nom, int id, Hero hero) {
        this.nom = nom;
        this.id = id;
        this.hero = hero;
    }


    public Joueur(String nom, int id, Hero hero, Pouvoir p) {
        this.nom = nom;
        this.id = id;
        this.hero = hero;
        this.pouvoir = p;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero(){
        return this.hero;
    }


    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

