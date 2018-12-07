
public class Joueur {
    String nom;
    int id;
    Hero hero;
    Pouvoir pouvoir;

    public Joueur(String nom, int id) {
        this.nom = nom;
        this.id = id;
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


}

