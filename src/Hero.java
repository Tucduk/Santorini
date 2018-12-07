public class Hero  {

    String nomHero;
    Pouvoir pouvoir;


    public Hero(String nomHero){
        this.nomHero = nomHero;
    }


    public void setNomHero(String nom){
        this.nomHero = nom;
    }

    public String getNomHero(){
        return this.nomHero;
    }

    public void setPouvoir(Pouvoir pouvoir){
        this.pouvoir = pouvoir;
    }

    public Pouvoir getPouvoir() {
        return pouvoir;
    }
}
