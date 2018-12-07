import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import java.awt.*;    // Pour la JFrame
import java.awt.event.*;
import java.util.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controller implements ActionListener {
    Plateau p;
    Model m;
    Pouvoir pouv;
    JButton button;
    private char firsti;
    private char secondei;
    private char secondej;
    private char firstj;
    int indiceInitI;
    int indiceInitJ;
    int indiceSecondeI;
    int indiceSecondeJ;
    int indicePionBougeeI = 0;
    int indicePionBougeeJ = 0;
    boolean firstSelect = false;
    boolean mouvementPion = false;
    Piece piece;
    boolean pouvoirActive = false;
    private int etage[][] = new int[6][6];
    private String tourEquipe = "noir";
    private boolean erreur = false;
    private boolean construction = true;


    public Controller(Plateau p, Model m) {
        this.p = p;
        this.m = m;
        p.setBoutonControler(this);

    }

    public void ActiverPouvoir(){
        pouvoirActive = true;
    }


    public void actionPerformed(ActionEvent e) {

        String actionCommande = e.getActionCommand();

        if (actionCommande == "pouvoir") {
            if (m.getTour() > 4) {

                Pouvoir pouvoir = new Pouvoir(this);

                p.joueur1.getHero().setPouvoir(pouvoir);
                p.joueur2.getHero().setPouvoir(pouvoir);

                if (m.getTour() % 2 == 0) {
                    p.joueur2.getHero().getPouvoir().utiliserPouvoir(p.joueur2.getHero().getNomHero());
                } else {
                    p.joueur1.getHero().getPouvoir().utiliserPouvoir(p.joueur1.getHero().getNomHero());
                }

            }
        } else {

            if (m.getTour() % 2 == 0) {
                tourEquipe = "white";
            } else {
                tourEquipe = "black";
            }

            // tour de jeu
            if (m.getTour() > 4) {

                if (m.getDeplacementPossible() != 0) {
                    // deplacement pion

                    if (m.getPionSelectionner() == null) {


                        firsti = actionCommande.charAt(0);
                        firstj = actionCommande.charAt(1);
                        indiceInitI = firsti - '0';
                        indiceInitJ = firstj - '0';


                        if ((p.pion[indiceInitI][indiceInitJ] != null)) {

                            if (tourEquipe == (p.pion[indiceInitI][indiceInitJ].getCouleur())) {

                                m.setPionSelectionner(p.pion[indiceInitI][indiceInitJ]);

                                //p.roseDesVents(indiceInitI, indiceInitJ);
                                p.labelMessage.setText("Cliquez sur une case pour déplacer le pion");

                            } else {
                                p.dialogPerdu("Veuillez cliquez sur un de vos pions (de meme couleur)");

                            }

                        } else {
                            firstSelect = false;
                            p.dialogPerdu("Veuillez cliquez sur un de vos pions");
                        }


                    } else {

                        secondei = actionCommande.charAt(0);
                        secondej = actionCommande.charAt(1);
                        indiceSecondeI = secondei - '0';
                        indiceSecondeJ = secondej - '0';

                        int diffI = indiceInitI - indiceSecondeI;
                        int diffJ = indiceInitJ - indiceSecondeJ;
                        diffI = Math.abs(diffI);
                        diffJ = Math.abs(diffJ);

                        // Swap

                        if ((p.pion[indiceSecondeI][indiceSecondeJ] == null)) {


                            if ((diffI < 2 && diffJ < 2)) {

                                indicePionBougeeI = indiceSecondeI;
                                indicePionBougeeJ = indiceSecondeJ;


                                if (p.pion[indiceInitI][indiceInitJ].getCouleur() == "white") {

                                    switch (etage[indiceSecondeI][indiceSecondeJ]) {
                                        case 0:
                                            p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/pion_blanc.PNG"));
                                            erreur = false;
                                            break;
                                        case 1:
                                            p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage1_pion_blanc.PNG"));
                                            break;
                                        case 2:
                                            if ((etage[indiceInitI][indiceInitJ] == 1) || (etage[indiceInitI][indiceInitJ] == 2)) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage2_pion_blanc.PNG"));
                                                erreur = false;
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }
                                            break;
                                        case 3:
                                            if ((etage[indiceInitI][indiceInitJ] == 2) || (etage[indiceInitI][indiceInitJ] == 3)) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage3_pion_blanc.PNG"));
                                                erreur = false;
                                                if (etage[indiceInitI][indiceInitJ] == 2) {
                                                    p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage2.PNG"));
                                                }
                                                if (etage[indiceInitI][indiceInitJ] == 3) {
                                                    p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage3.PNG"));
                                                }
                                                p.dialogPerdu("GAGNER");
                                                p.gagner();
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }
                                            break;
                                        case 4:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                    }
                                    switch (etage[indiceInitI][indiceInitJ]) {
                                        case 0:
                                            if (!erreur) {
                                                p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/Sol5.PNG"));
                                            }
                                            break;
                                        case 1:
                                            if (!erreur) {
                                                p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage1.PNG"));
                                            }
                                            break;
                                        case 2:
                                            if (!erreur) {
                                                p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage2.PNG"));
                                            }
                                            break;


                                        case 3:
                                            if (!erreur) {
                                                p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage3.PNG"));
                                            }
                                            break;
                                    }


                                    if (!erreur) {
                                        p.pion[indiceSecondeI][indiceSecondeJ] = p.pion[indiceInitI][indiceInitJ];
                                        p.pion[indiceInitI][indiceInitJ] = null;
                                        m.setPionSelectionner(p.pion[indiceSecondeI][indiceSecondeJ]);
                                        firstSelect = false;
                                        m.setDeplacementPossible(m.getDeplacementPossible() - 1);
                                        p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                        if (m.getDeplacementPossible() == 0) {
                                            p.labelMessage.setText("Constuire");
                                        }

                                    }


                                } else {
                                    switch (etage[indiceSecondeI][indiceSecondeJ]) {
                                        case 0:
                                            p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/pion_noir.PNG"));
                                            erreur = false;
                                            break;
                                        case 1:
                                            p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage1_pion_noir.PNG"));
                                            erreur = false;
                                            break;
                                        case 2:
                                            if ((etage[indiceInitI][indiceInitJ] == 1) || (etage[indiceInitI][indiceInitJ] == 2)) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage2_pion_noir.PNG"));
                                                erreur = false;
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }
                                            break;
                                        case 3:
                                            if ((etage[indiceInitI][indiceInitJ] == 2) || (etage[indiceInitI][indiceInitJ] == 3)) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage3_pion_noir.PNG"));
                                                erreur = false;
                                                if (etage[indiceInitI][indiceInitJ] == 2) {
                                                    p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage2.PNG"));
                                                }
                                                if (etage[indiceInitI][indiceInitJ] == 3) {
                                                    p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage3.PNG"));
                                                }
                                                p.dialogPerdu("GAGNER");
                                                p.gagner();
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }
                                            break;
                                        case 4:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                    }
                                    switch (etage[indiceInitI][indiceInitJ]) {
                                        case 0:
                                            if (!erreur) {
                                                m.setSol(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                            }
                                            break;
                                        case 1:
                                            if (!erreur) {
                                                m.setSol1(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                            }
                                            break;
                                        case 2:
                                            if (!erreur) {
                                                m.setSol2(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                            }
                                            break;
                                        case 3:
                                            if (!erreur) {
                                                m.setSol3(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                            }
                                            break;
                                    }


                                    if (!erreur) {
                                        p.pion[indiceSecondeI][indiceSecondeJ] = p.pion[indiceInitI][indiceInitJ];
                                        p.pion[indiceInitI][indiceInitJ] = null;

                                        m.setPionSelectionner(p.pion[indiceSecondeI][indiceSecondeJ]);
                                        firstSelect = false;
                                        m.setDeplacementPossible(m.getDeplacementPossible() - 1);
                                        p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                        if (m.getDeplacementPossible() == 0) {
                                            p.labelMessage.setText("Constuire");
                                        }

                                    }

                                }

                            } else {
                                p.dialogPerdu("Deplacement impossible (deplacement en rose des sables)");
                            }

                        } else {
                            p.dialogPerdu("Deplacement impossible (pas sur un autre pion)");

                        }
                    }


                } else {

                    // construction

                    pouvoirActive = false;

                    firsti = actionCommande.charAt(0);
                    firstj = actionCommande.charAt(1);
                    indiceInitI = firsti - '0';
                    indiceInitJ = firstj - '0';

                    int diffI = indiceInitI - indicePionBougeeI;
                    int diffJ = indiceInitJ - indicePionBougeeJ;
                    diffI = Math.abs(diffI);
                    diffJ = Math.abs(diffJ);

                    if (p.pion[indiceInitI][indiceInitJ] == null) {

                        if ((diffI < 2 && diffJ < 2)) {


                            switch (etage[indiceInitI][indiceInitJ]) {
                                case 0:
                                    m.setSol1(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    etage[indiceInitI][indiceInitJ] = etage[indiceInitI][indiceInitJ] + 1;
                                    construction = true;
                                    break;
                                case 1:
                                    m.setSol2(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    etage[indiceInitI][indiceInitJ] = etage[indiceInitI][indiceInitJ] + 1;
                                    construction = true;
                                    break;
                                case 2:
                                    m.setSol3(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    etage[indiceInitI][indiceInitJ] = etage[indiceInitI][indiceInitJ] + 1;
                                    construction = true;
                                    break;
                                case 3:
                                    m.setSol4(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    etage[indiceInitI][indiceInitJ] = etage[indiceInitI][indiceInitJ] + 1;
                                    construction = true;
                                    break;
                                case 4:
                                    construction = false;

                            }

                            if (construction) {
                                m.setTour(m.getTour()+1);
                                p.labelTour.setText(" " + m.getTour());
                                m.setConstructionPossible(m.getConstructionPossible() - 1);
                                p.labelConstruction.setText("" + m.getConstructionPossible());

                                if(m.getConstructionPossible() == 0) {
                                    m.setPionSelectionner(null);
                                    m.setConstructionPossible(m.getConstructionPossible() + 1);
                                    p.labelConstruction.setText("" + m.getConstructionPossible());
                                    m.setDeplacementPossible(m.getDeplacementPossible() + 1);
                                    p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                    p.labelMessage.setText("Joueur 1, deplacer le pion de votre choix en cliquant dessus");
                                }


                                if (m.getTour() % 2 == 0) {
                                    p.labelJoueur.setText(p.joueur2.getNom() + " (blanc)");
                                } else {
                                    p.labelJoueur.setText(p.joueur1.getNom() + " (noir)");
                                }

                            } else {
                                p.dialogPerdu("construction impossible");

                            }

                        } else {
                            p.dialogPerdu("construction impossible (chosir une case adjacente)");

                        }
                    } else {

                        p.dialogPerdu("construction impossible");
                    }

                }

            } else {

                //tour d'initialisation pion

                firsti = actionCommande.charAt(0);
                firstj = actionCommande.charAt(1);
                indiceInitI = firsti - '0';
                indiceInitJ = firstj - '0';


                if (m.getTour() % 2 == 0) {
                    piece = new Piece("white");
                    piece.setCouleur("white");

                    if (p.pion[indiceInitI][indiceInitJ] == null) {


                        piece.setPion(p.tableauDeButton[indiceInitI][indiceInitJ]);
                        p.pion[indiceInitI][indiceInitJ] = piece;
                        m.setTour(m.getTour()+1);
                        p.labelMessage.setText("Cliquez sur une case pour placer le " + m.getTour() + "ème pion");
                        p.labelTour.setText("initialisation " + m.getTour());

                        if (m.getTour() == 5) {
                            p.labelTour.setText(" " + m.getTour());
                            p.labelMessage.setText("Joueur 1, deplacer le pion de votre choix en cliquant dessus");
                        }


                        if (m.getTour()% 2 == 0) {
                            p.labelJoueur.setText(p.joueur2.getNom() + " (blanc)");
                        } else {
                            p.labelJoueur.setText(p.joueur1.getNom() + " (noir)");
                        }

                    }
                } else {
                    piece = new Piece("black");
                    piece.setCouleur("black");

                    if (p.pion[indiceInitI][indiceInitJ] == null) {

                        piece.setPion(p.tableauDeButton[indiceInitI][indiceInitJ]);
                        p.pion[indiceInitI][indiceInitJ] = piece;
                        m.setTour(m.getTour()+1);
                        p.labelMessage.setText("Cliquez sur une case pour placer le " + m.getTour() + "ème pion");
                        p.labelTour.setText("initialisation " + m.getTour());

                        if (m.getTour() == 5) {
                            p.labelTour.setText(" " + m.getTour());                        }
                        if (m.getTour() % 2 == 0) {
                            p.labelJoueur.setText(p.joueur2.getNom() + " (blanc)");
                        } else {
                            p.labelJoueur.setText(p.joueur1.getNom() + " (noir)");
                        }
                    }
                }
            }
        }
    }
}
