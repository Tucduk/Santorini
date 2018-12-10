import javax.swing.*;

public class Model {

    private static int tour = 1;
    private static int deplacementPossible = 1;
    private static int constructionPossible = 1;
    private Piece PionSelectionner;
    private int etage[][] = new int[6][6];
    private int opacity[][] = new int[6][6];


    public static int getDeplacementPossible() {
        return deplacementPossible;
    }

    public static void setDeplacementPossible(int deplacementPossible) {
        Model.deplacementPossible = deplacementPossible;
    }

    public static int getConstructionPossible() {
        return constructionPossible;
    }

    public static void setConstructionPossible(int constructionPossible) {
        Model.constructionPossible = constructionPossible;
    }

    public static int getTour() {
        return tour;
    }

    public static void setTour(int tour) {
        Model.tour = tour;
    }


    public void setPionBlanc(JButton b) {
        Icon Pion_blanc = new ImageIcon("imageSantorini/pion_blanc.PNG");
        b.setIcon(Pion_blanc);
    }



    public void setPionNoir(JButton b) {
        Icon Pion_noir = new ImageIcon("imageSantorini/pion_noir.PNG");
        b.setIcon(Pion_noir);
    }

    public void setSol(JButton b) {
        Icon Sol = new ImageIcon("imageSantorini/Sol.PNG");
        b.setIcon(Sol);
    }
    public void setSolDome(JButton b) {
        Icon Sol = new ImageIcon("imageSantorini/maison_etage0_dome.PNG");
        b.setIcon(Sol);
    }

    public void setSol1(JButton b) {
        Icon Sol1 = new ImageIcon("imageSantorini/maison_etage1.PNG");
        b.setIcon(Sol1);
    }

    public void setSol1Dome(JButton b) {
        Icon Sol1 = new ImageIcon("imageSantorini/maison_etage1_dome.PNG");
        b.setIcon(Sol1);
    }

    public void setSol2(JButton b) {
        Icon Sol2 = new ImageIcon("imageSantorini/maison_etage2.PNG");
        b.setIcon(Sol2);
    }

    public void setSol2Dome(JButton b) {
        Icon Sol2 = new ImageIcon("imageSantorini/maison_etage2_dome.PNG");
        b.setIcon(Sol2);
    }

    public void setSol3(JButton b) {
        Icon Sol3 = new ImageIcon("imageSantorini/maison_etage3.PNG");
        b.setIcon(Sol3);
    }

    public void setSol3Dome(JButton b) {
        Icon Sol3 = new ImageIcon("imageSantorini/maison_etage3_dome.PNG");
        b.setIcon(Sol3);
    }

    public void setSol4(JButton b) {
        Icon Sol4 = new ImageIcon("imageSantorini/maison_etage4.PNG");
        b.setIcon(Sol4);
    }

    public void PionBlancEtage1(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_blanc.PNG");
        b.setIcon(icon);
    }

    public void PionBlancEtage2(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_blanc.PNG");
        b.setIcon(icon);
    }

    public void PionBlancEtage3(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_blanc.PNG");
        b.setIcon(icon);
    }

    public void PionNoirEtage1(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_noir.PNG");
        b.setIcon(icon);
    }

    public void PionNoirEtage2(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_noir.PNG");
        b.setIcon(icon);
    }

    public void PionNoirEtage3(JButton b) {
        Icon icon = new ImageIcon("imageSantorini/maison_etage1_pion_noir.PNG");
        b.setIcon(icon);
    }


    public Piece getPionSelectionner() {
        return PionSelectionner;
    }

    public void setPionSelectionner(Piece pionSelectionner) {
        PionSelectionner = pionSelectionner;
    }

    public int[][] getEtage() {
        return etage;
    }

    public int etageRechercher(int i, int j){
        return etage[i][j];
    }

    public void setEtage(int[][] etage) {
        this.etage = etage;
    }

    public void etageModif(int i,int j, int n){
        this.etage[i][j] = n;
    }

    public void opacityModif(int i,int j, int n){
        this.opacity[i][j] = n;
    }

    public int opacityRechercher(int i, int j){
        return opacity[i][j];
    }

}
