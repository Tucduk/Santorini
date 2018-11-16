import javafx.scene.image.ImageView;

import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import javax.swing.border.LineBorder;
import java.awt.*;    // Pour la JFrame
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Plateau extends JFrame implements ActionListener {
    private Piece plateau[][];
    Controller controlb;
    JButton but;
    JButton tableauDeButton[][];
    JButton quitter = new JButton("quitter");
    JButton restart = new JButton("rejouer");
    Piece pion[][] = new Piece[6][6];
    JLabel labelMessage;
    JLabel labelTour;
    JLabel labelJoueur;
    Model m;


    public Plateau(Model m) {
        this.m = m;
        initPLateau();
        setTitle("Santorini");
        setLocation(500, 0);
        setResizable(false);
        pack();
        setVisible(true);
        labelTour.setText("initialisation 1");
        labelJoueur.setText("Thomas (noir)");
        labelMessage.setText("Cliquez sur une case pour placer le 1er pion");
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void roseDesVents(int i, int j) {
        if (pion[i + 1][j] == null) {
            //tableauDeButton[i+1][j].setIcon(new ImageIcon(""));
        }

        if (pion[i][j + 1] == null) {
            //tableauDeButton[i][j+1].setIcon(new ImageIcon(""));
        }

        if (pion[i - 1][j] == null) {
            //tableauDeButton[i-1][j].setIcon(new ImageIcon(""));
        }

        if (pion[i + 1][j - 1] == null) {
            //tableauDeButton[i+1][j-1].setIcon(new ImageIcon(""));
        }

        if (pion[i - 1][j - 1] == null) {
            //tableauDeButton[i-1][j-1].setIcon(new ImageIcon(""));
        }

        if (pion[i + 1][j + 1] == null) {
            //tableauDeButton[i+1][j+1].setIcon(new ImageIcon(""));
        }

        if (pion[i - 1][j + 1] == null) {
            //tableauDeButton[i-1][j+1].setIcon(new ImageIcon(""));
        }

        if (pion[i][j - 1] == null) {
            //tableauDeButton[i][j-1].setIcon(new ImageIcon(""));
        }

    }

    public void gagner() {
        Container cp = this.getContentPane();
        cp.removeAll();

        JLabel tf = new JLabel("Merci d'avoir jouer a Santorini! Felicitation au vaincqueur!");

        JPanel p8 = new JPanel();
        p8.setPreferredSize(new Dimension(350, 100));
        restart.setPreferredSize(new Dimension(100, 30));
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                setVisible(false);
                Plateau p = new Plateau(m);
            }
        });
        p8.add(restart);

        JPanel p7 = new JPanel();
        p7.setPreferredSize(new Dimension(350, 150));
        quitter.setPreferredSize(new Dimension(100, 30));
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);

            }
        });
        p7.add(quitter);

        JPanel pSGlobal = new JPanel();
        pSGlobal.setLayout(new BoxLayout(pSGlobal, BoxLayout.Y_AXIS));
        pSGlobal.add(p8);
        pSGlobal.add(p7);


        JPanel pGlobal = new JPanel();
        pGlobal.setLayout(new BoxLayout(pGlobal, BoxLayout.Y_AXIS));
        pGlobal.add(tf);
        pGlobal.add(pSGlobal);


        setContentPane(pGlobal);

        repaint();
        validate();
        setVisible(true);
        pack();

    }


    public void setBoutonControler(ActionListener listener) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tableauDeButton[i][j].addActionListener(listener);
            }

        }
        quitter.addActionListener(listener);
        restart.addActionListener(listener);

    }


    public void initPLateau() {
        JPanel p = new JPanel(new GridLayout(6, 6, 0, 0));


        int largeur = 6;
        int longeur = 6;
        tableauDeButton = new JButton[largeur][longeur];
        Button button;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                tableauDeButton[i][j] = new JButton();
                tableauDeButton[i][j].setActionCommand("" + i + "" + j);
                tableauDeButton[i][j].setPreferredSize(new Dimension(150, 150));

                m.setSol(tableauDeButton[i][j]);
                tableauDeButton[i][j].setOpaque(false);
                tableauDeButton[i][j].setContentAreaFilled(false);
                tableauDeButton[i][j].setBorderPainted(false);

                tableauDeButton[i][j].addActionListener(this);


                p.add(tableauDeButton[i][j]);
            }
        }


        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(100, 40));
        p2.add(new JLabel("Message :   "));
        labelMessage = new JLabel("");
        p2.add(labelMessage);

        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(100, 20));
        p4.add(new JLabel("Tour :   "));
        labelTour = new JLabel(" 0");
        p4.add(labelTour);


        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(100, 20));
        p5.add(new JLabel("Joueur :   "));
        labelJoueur = new JLabel("Thomas");
        p5.add(labelJoueur);


        JPanel pBoxGlobal = new JPanel();
        pBoxGlobal.setLayout(new BoxLayout(pBoxGlobal, BoxLayout.Y_AXIS));
        pBoxGlobal.add(p);
        pBoxGlobal.add(p4);
        pBoxGlobal.add(p5);
        pBoxGlobal.add(p2);


        setContentPane(pBoxGlobal);


    }


    public Piece[][] getPlateau() {
        return this.plateau;
    }


    public void actionPerformed(ActionEvent e) {

    }

    public void dialogPerdu(String messageErr) {

        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(this, messageErr, "Message", JOptionPane.ERROR_MESSAGE);

    }

    public void close() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(false);
    }

}