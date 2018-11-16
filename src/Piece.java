import javax.swing.*;
import java.util.*;

public class Piece {
    private int x;
    private int y;
    private String couleur;
    private String nom;

    public Piece(int x, int y, String couleur, String nom) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.nom = nom;
    }

    protected String pos;


    public Piece(String nom) {
        this.nom = nom;
        this.pos = "";
        this.couleur = "";
    }


    public void setPion(JButton button) {
        if ("white".equals(this.couleur)) {
            button.setIcon(new ImageIcon("imageSantorini/pion_blanc.PNG"));
        } else {
            button.setIcon(new ImageIcon("imageSantorini/pion_noir.PNG"));
        }
    }


    public Piece() {
    }

    public int getPosX() {
        return this.x;
    }

    public int getPosY() {
        return this.y;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public String getNom() {
        return this.nom;
    }

    public int setPosX(int x) {
        return this.x = x;
    }

    public int setPosY(int y) {
        return this.y = y;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String setNom(String nom) {
        return this.nom = nom;
    }

}