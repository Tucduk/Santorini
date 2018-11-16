import javax.swing.*;

public class Model {

    private int tour;


    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
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
        Icon Sol = new ImageIcon("imageSantorini/Sol5.PNG");
        b.setIcon(Sol);
    }

    public void setSol1(JButton b) {
        Icon Sol1 = new ImageIcon("imageSantorini/maison_etage1.PNG");
        b.setIcon(Sol1);
    }

    public void setSol2(JButton b) {
        Icon Sol2 = new ImageIcon("imageSantorini/maison_etage2.PNG");
        b.setIcon(Sol2);
    }

    public void setSol3(JButton b) {
        Icon Sol3 = new ImageIcon("imageSantorini/maison_etage3.PNG");
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




}
