package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class Pion extends Joueur{
    protected String couleur;
    protected String pos;

    Image pion = new Image("/imageSantorini/Pion1.PNG", 150, 150, true, true);
    Image pion2 = new Image("/imageSantorini/Pion2.PNG", 150, 150, true, true);

    Image[] imagePion = {pion, pion2};

    public Pion(String nom, int id){
        super(nom,id);
        this.pos = "";
        this.couleur = "";
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public void setPion(Button button){
        if ("white".equals(this.couleur)){
            button.setGraphic(new ImageView(imagePion[1]));
            this.pos = button.getId();
        }else{
            button.setGraphic(new ImageView(imagePion[0]));
            this.pos = button.getId();
        }
    }
}
