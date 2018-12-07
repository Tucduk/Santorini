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
    JButton pouvoir;
    JButton tableauDeButton[][];
    Joueur joueur1;
    Joueur joueur2;
    JButton quitter = new JButton("quitter");
    JButton restart = new JButton("rejouer");
    Piece pion[][] = new Piece[6][6];
    String[] nom = {"default", "Achilles", "Aeolus", "Aphrodite", "Apollo", "Ares", "Artemis", "Atalanta", "Athena", "Atlas", "Bellerophon"};
    Hero[] tableauHero;
    static String heroChoisis = "";
    JLabel labelMessage;
    JLabel labelTour;
    JLabel labelJoueur;
    JLabel labelConstruction;
    JLabel labelDeplacement;
    Model m;
    JPanel panel3;

    JTextField Text_Player_name;
    JTextField Text_Player_name2;
    JPanel Page_Selection_nom;
    JPanel Page_Selection_nom2;
    JButton Validation_player;


    JPanel nom_panel;
    JPanel nom_panel2;
    JPanel validation_panel;
    JLabel nom_formulaire;
    JLabel nom_formulaire2;



    JTextField Text_Player_Age;
    JLabel Age_formulaire;
    JPanel age_panel;
    JTextField Text_Player_Age2;
    JLabel Age_formulaire2;
    JPanel age_panel2;
    JLabel Image;


    JComboBox liste1;
    JPanel panel1 = new JPanel();
    ImageIcon image;
    JPanel panel2 = new JPanel();
    JLabel imagelabel;

    JButton bChangerPanel = new JButton("valider");


    public Plateau(Model m) {
        this.m = m;
        pageConnexion();
        setTitle("Santorini");
        setLocation(500, 0);
        setResizable(false);
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

    public void pageConnexion() {

        //        Nom Player 1
        Text_Player_name = new JTextField();
        nom_formulaire = new JLabel("Nom :");
        Text_Player_name.setPreferredSize(new Dimension(100, 20));
        nom_panel = new JPanel();
        nom_panel.add(nom_formulaire);
        nom_panel.add(Text_Player_name);

//        age player 1
        Text_Player_Age = new JTextField();
        Age_formulaire = new JLabel("Age :");
        Text_Player_Age.setPreferredSize(new Dimension(100, 20));
        age_panel = new JPanel();
        age_panel.add(Age_formulaire);
        age_panel.add(Text_Player_Age);


        JPanel panel_joueur1 = new JPanel();
        JLabel ta_joueur1 = new JLabel("Joueur 1 : ");
        panel_joueur1.add(ta_joueur1);
        panel_joueur1.add(nom_panel);
        panel_joueur1.add(age_panel);
        panel_joueur1.setSize(new Dimension(10,10));



        //        Nom Player 2
        Text_Player_name2 = new JTextField();
        nom_formulaire2 = new JLabel("Nom :");
        Text_Player_name2.setPreferredSize(new Dimension(100, 20));
        nom_panel2 = new JPanel();
        nom_panel2.add(nom_formulaire2);
        nom_panel2.add(Text_Player_name2);

//        age player 2
        Text_Player_Age2 = new JTextField();
        Age_formulaire2 = new JLabel("Age :");
        Text_Player_Age2.setPreferredSize(new Dimension(100, 20));
        age_panel2 = new JPanel();
        age_panel2.add(Age_formulaire2);
        age_panel2.add(Text_Player_Age2);


        JPanel panel_joueur2 = new JPanel();
        JLabel ta_joueur2 = new JLabel("Joueur 2 : ");
        panel_joueur2.add(ta_joueur2);
        panel_joueur2.add(nom_panel2);
        panel_joueur2.add(age_panel2);
        panel_joueur2.setPreferredSize(new Dimension(10,10));


//        Valider
        Validation_player = new JButton("valider");
        Validation_player.addActionListener(this);
        validation_panel = new JPanel();
        validation_panel.add(Validation_player);
        Image = new JLabel();


        panel1.add(panel_joueur1);

        panel1.add(panel_joueur2);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setPreferredSize(new Dimension(10,10));



        JComboBox liste1 = new JComboBox();


        for (int i = 0; i < nom.length; i++) {
            String temp = nom[i];
            liste1.addItem(temp);

        }


        JTextArea tf_notice = new JTextArea("Joueur 1 : Veuillez choisir un hero ou dieu");
        this.panel2.add(tf_notice);
        this.panel2.add(liste1);
        ImageIcon icone = new ImageIcon("");
        JLabel image = new JLabel(icone);
        image.setSize(panel2.getWidth(), panel2.getHeight());
        panel2.add(image);
        panel2.repaint();
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.bChangerPanel.addActionListener(new EcouteurBoutonChanger());
        this.panel1.add(this.bChangerPanel);
        this.setContentPane(this.panel1);
        this.panel1.setBackground(Color.white);
        this.panel2.setBackground(Color.white);


        liste1.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) liste1.getSelectedItem();//get the selected item
                panel2.removeAll();
                panel2.repaint();
                panel2.add(liste1);
                JPanel jp_validate = new JPanel();
                JButton bt_valider = new JButton("valider");
                bt_valider.addActionListener(new EcouteurBoutonValiderJoueur1());
                heroChoisis = s;

                switch (s) {//check for a match
                    case "default":
                        dialogPerdu("Choisis un hero ou dieu");
                        ImageIcon icone3 = new ImageIcon("");
                        JLabel image3 = new JLabel(icone3);
                        image3.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image3);
                        panel2.repaint();
                        break;

                    case "Achilles":
                        ImageIcon icone2 = new ImageIcon("imageSantorini/Achilles.png");
                        JLabel image2 = new JLabel(icone2);
                        image2.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image2);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Aeolus":
                        ImageIcon icone = new ImageIcon("imageSantorini/Aeolus.PNG");
                        JLabel image = new JLabel(icone);
                        image.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Aphrodite":
                        ImageIcon icone12 = new ImageIcon("imageSantorini/Aphrodite.PNG");
                        JLabel image12 = new JLabel(icone12);
                        image12.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image12);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Apollo":
                        ImageIcon icone4 = new ImageIcon("imageSantorini/Apollo.PNG");
                        JLabel image4 = new JLabel(icone4);
                        image4.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image4);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Ares":
                        ImageIcon icone5 = new ImageIcon("imageSantorini/Ares.PNG");
                        JLabel image5 = new JLabel(icone5);
                        image5.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image5);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Artemis":
                        ImageIcon icone6 = new ImageIcon("imageSantorini/Artemis.PNG");
                        JLabel image6 = new JLabel(icone6);
                        image6.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image6);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Atalanta":
                        ImageIcon icone7 = new ImageIcon("imageSantorini/Atalanta.PNG");
                        JLabel image7 = new JLabel(icone7);
                        image7.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image7);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Athena":
                        ImageIcon icone8 = new ImageIcon("imageSantorini/Athena.PNG");
                        JLabel image8 = new JLabel(icone8);
                        image8.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image8);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Atlas":
                        ImageIcon icone9 = new ImageIcon("imageSantorini/Atlas.PNG");
                        JLabel image9 = new JLabel(icone9);
                        image9.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image9);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Bellerophon":
                        ImageIcon icone10 = new ImageIcon("imageSantorini/Bellerophon.PNG");
                        JLabel image10 = new JLabel(icone10);
                        image10.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image10);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                }
            }
        });


    }


    public void jeu() {

        panel2.removeAll();
        this.repaint();
        initPLateau();
        labelTour.setText("initialisation 1");
        labelJoueur.setText(joueur1.getNom() + " (noir)");
        labelMessage.setText("Cliquez sur une case pour placer le 1er pion");

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
        pouvoir.addActionListener(listener);

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
        p2.setPreferredSize(new Dimension(100, 20));
        p2.add(new JLabel("Message :   "));
        labelMessage = new JLabel("");
        p2.add(labelMessage);

        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(100, 20));
        p4.add(new JLabel("Tour :   "));
        labelTour = new JLabel(" 0");
        p4.add(labelTour);

        JPanel p8 = new JPanel();
        p8.setPreferredSize(new Dimension(100, 20));
        p8.add(new JLabel("Deplacement possible :   "));
        labelDeplacement = new JLabel(" 1");
        p8.add(labelDeplacement);

        JPanel p9 = new JPanel();
        p9.setPreferredSize(new Dimension(100, 20));
        p9.add(new JLabel("Construction possible :   "));
        labelConstruction = new JLabel(" 1");
        p9.add(labelConstruction);

        JPanel pglob = new JPanel();
        pglob.setPreferredSize(new Dimension(100, 20));
        pglob.setLayout(new BoxLayout(pglob, BoxLayout.X_AXIS));
        pglob.add(p4);
        pglob.add(p8);
        pglob.add(p9);

        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(100, 20));
        p5.add(new JLabel("Joueur :   "));
        labelJoueur = new JLabel(joueur1.getNom());
        p5.add(labelJoueur);


        JPanel p6 = new JPanel();
        p6.setPreferredSize(new Dimension(100, 40));
        pouvoir = new JButton("pouvoir");
        p6.add(pouvoir);


        JPanel pBoxGlobal = new JPanel();
        pBoxGlobal.setLayout(new BoxLayout(pBoxGlobal, BoxLayout.Y_AXIS));
        pBoxGlobal.add(p);
        pBoxGlobal.add(pglob);
        pBoxGlobal.add(p5);
        pBoxGlobal.add(p2);
        pBoxGlobal.add(p6);


        setContentPane(pBoxGlobal);
        pack();
        controlb = new Controller(this, m);
        setBoutonControler(this);

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

    public class EcouteurBoutonChanger implements ActionListener {
        public void actionPerformed(ActionEvent clic) {

            int age_joueur1 = 0;
            int age_joueur2 = 0;

            if ((Text_Player_name.getText().equals("")) && (Text_Player_Age.getText().equals("")) && (Text_Player_name2.getText().equals("")) && (Text_Player_Age2.getText().equals(""))) {
                dialogPerdu("Veuillez rentrer les informations des joueurs");
            } else {

                try{
                    age_joueur1 = Integer.valueOf(Text_Player_Age.getText());
                    age_joueur2 = Integer.valueOf(Text_Player_Age2.getText());

                    if(age_joueur1 < age_joueur2) {
                        joueur1 = new Joueur(Text_Player_name.getText(), 1);
                        joueur2 = new Joueur(Text_Player_name2.getText(), 2);
                    }
                    else {
                        joueur2 = new Joueur(Text_Player_name.getText(), 1);
                        joueur1 = new Joueur(Text_Player_name2.getText(), 2);
                    }
                    changerMenu();

                }
                catch(Exception e1) {
                    dialogPerdu("Veuillez saisir un age correct");
                }

            }
        }
    }

    public class EcouteurBoutonValiderJoueur1 implements ActionListener {
        public void actionPerformed(ActionEvent clic) {
            Hero h = new Hero(heroChoisis);
            joueur1.setHero(h);

            changerMenu2();
        }
    }


    public class EcouteurBoutonValider implements ActionListener {
        public void actionPerformed(ActionEvent clic) {
            Hero h = new Hero(heroChoisis);
            joueur2.setHero(h);

            jeu();
        }
    }


    public void changerMenu() {

        this.setContentPane(this.panel2);
        this.revalidate();
    }

    public void changerMenu2() {

        panel2.removeAll();

        JComboBox liste2 = new JComboBox();

        for (int i = 0; i < nom.length; i++) {
            if(heroChoisis.equals(nom[i])){

            }
            else{
                String temp = nom[i];
                liste2.addItem(temp);
            }

        }

        JTextArea tf_notice = new JTextArea("Joueur 2 : Veuillez choisir un hero ou dieu");
        this.panel2.add(tf_notice);
        this.panel2.add(liste2);
        ImageIcon icone = new ImageIcon("");
        JLabel image = new JLabel(icone);
        image.setSize(panel2.getWidth(), panel2.getHeight());
        panel2.add(image);
        panel2.repaint();
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.bChangerPanel.addActionListener(new EcouteurBoutonChanger());
        this.panel2.setBackground(Color.white);

        this.setContentPane(this.panel2);
        this.revalidate();
        setLocation(500, 0);


        liste2.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) liste2.getSelectedItem();//get the selected item
                panel2.removeAll();
                panel2.repaint();
                panel2.add(liste2);
                JPanel jp_validate = new JPanel();
                JButton bt_valider = new JButton("valider");
                bt_valider.addActionListener(new EcouteurBoutonValider());
                heroChoisis = s;


                switch (s) {//check for a match
                    case "default":
                        dialogPerdu("Choisis un hero ou dieu");
                        ImageIcon icone3 = new ImageIcon("");
                        JLabel image3 = new JLabel(icone3);
                        image3.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image3);
                        panel2.repaint();
                        break;

                    case "Achilles":

                        ImageIcon icone2 = new ImageIcon("imageSantorini/Achilles.png");
                        JLabel image2 = new JLabel(icone2);
                        image2.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image2);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Aeolus":
                        ImageIcon icone = new ImageIcon("imageSantorini/Aeolus.PNG");
                        JLabel image = new JLabel(icone);
                        image.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Aphrodite":
                        ImageIcon icone12 = new ImageIcon("imageSantorini/Aphrodite.PNG");
                        JLabel image12 = new JLabel(icone12);
                        image12.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image12);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Apollo":
                        ImageIcon icone4 = new ImageIcon("imageSantorini/Apollo.PNG");
                        JLabel image4 = new JLabel(icone4);
                        image4.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image4);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Ares":
                        ImageIcon icone5 = new ImageIcon("imageSantorini/Ares.PNG");
                        JLabel image5 = new JLabel(icone5);
                        image5.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image5);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Artemis":
                        ImageIcon icone6 = new ImageIcon("imageSantorini/Artemis.PNG");
                        JLabel image6 = new JLabel(icone6);
                        image6.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image6);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Atalanta":
                        ImageIcon icone7 = new ImageIcon("imageSantorini/Atalanta.PNG");
                        JLabel image7 = new JLabel(icone7);
                        image7.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image7);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Athena":
                        ImageIcon icone8 = new ImageIcon("imageSantorini/Athena.PNG");
                        JLabel image8 = new JLabel(icone8);
                        image8.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image8);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Atlas":
                        ImageIcon icone9 = new ImageIcon("imageSantorini/Atlas.PNG");
                        JLabel image9 = new JLabel(icone9);
                        image9.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image9);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                    case "Bellerophon":
                        ImageIcon icone10 = new ImageIcon("imageSantorini/Bellerophon.PNG");
                        JLabel image10 = new JLabel(icone10);
                        image10.setSize(panel2.getWidth(), panel2.getHeight());
                        panel2.add(image10);
                        jp_validate.add(bt_valider);
                        panel2.add(jp_validate);
                        panel2.validate();
                        panel2.repaint();
                        break;
                }
            }
        });




    }


}