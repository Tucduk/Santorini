package sample;

import javafx.scene.Parent;

public class Fenetre extends Parent {
    private int[][] plateau;

    public Fenetre(Plateau plateau){
        this.plateau = plateau.getPlateau();
    }
}
