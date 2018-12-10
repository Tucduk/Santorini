

public class Dieu {

    String nomDieu;
    Pouvoir pouvoir;


    public Dieu(String nomHero) {
        this.nomDieu = nomHero;
    }


    public void setNomHero(String nom) {
        this.nomDieu = nom;
    }

    public String getNomHero() {
        return this.nomDieu;
    }

    public void setPouvoir(Pouvoir pouvoir) {
        this.pouvoir = pouvoir;
    }

    public Pouvoir getPouvoir() {
        return pouvoir;
    }
}

