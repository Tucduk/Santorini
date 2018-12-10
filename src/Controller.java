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

    Pouvoir pouvoir;
    boolean pouvoirActive = false;
    boolean pouvoirDome = false;
    boolean pouvoirEtage = false;
    boolean pouvoirMonter = false;
    boolean pouvoirHades = false;
    boolean IMPdescendreDeUN = false;
    boolean erreurHero = false;
    boolean pouvoirArtemis = false;
    boolean pouvoirPan = false;
    boolean pouvoirConstruction = false;

    JButton button;
    private char firsti;
    private char secondei;
    private char secondej;
    private char firstj;
    int indiceInitI;
    int indiceInitJ;
    int indiceSecondeI;
    int indiceSecondeJ;
    static int compteur = 1;
    int indicePionBougeeI = 0;
    int indicePionBougeeJ = 0;
    boolean firstSelect = false;
    boolean mouvementPion = false;
    Piece piece;
    private String tourEquipe = "rouge";
    private boolean erreur = false;
    private boolean construction = true;


    public Controller(Plateau p, Model m) {
        this.p = p;
        this.m = m;
        p.setBoutonControler(this);

    }

    public void ActiverPouvoir() {
        pouvoirActive = true;
    }


    public void actionPerformed(ActionEvent e) {

        String actionCommande = e.getActionCommand();



        if ((actionCommande == "pouvoir") || actionCommande == "annuler") {


            if(actionCommande == "pouvoir") {
                if (m.getTour() > 4) {


                    if (m.getTour() % 2 == 0) {
                        p.joueur2.getHero().getPouvoir().utiliserPouvoir(p.joueur2.getHero().getNomHero());
                    } else {
                        p.joueur1.getHero().getPouvoir().utiliserPouvoir(p.joueur1.getHero().getNomHero());
                    }

                }
            }
            else{
               if(!pouvoirArtemis) {
                   p.roseDesVents(indiceInitI, indiceInitJ, false);
                   m.setPionSelectionner(null);
               }
               else{
                   p.dialogPerdu("impossible d'annuler avec le pouvoir d'Artemis");
               }
            }
        } else {

            if (m.getTour() % 2 == 0) {
                tourEquipe = "white";
            } else {
                tourEquipe = "red";
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

                                p.roseDesVents(indiceInitI, indiceInitJ, true);
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


                                if (m.getPionSelectionner().getCouleur() == "white") {

                                    switch (m.etageRechercher(indiceSecondeI, indiceSecondeJ)) {
                                        case 0:
                                            if(pouvoirPan && (m.etageRechercher(indiceInitI, indiceInitJ) == 2)){
                                                p.dialogPerdu("GAGNER (Pouvoir Pan)");
                                                p.gagner();
                                            }

                                            if ((m.etageRechercher(indiceInitI, indiceInitJ) == 1) && IMPdescendreDeUN) {
                                                erreur = true;
                                                p.dialogPerdu("Impossible (Pouvoir Hades");
                                            } else {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage0_batisseur_blanc.PNG"));
                                                erreur = false;
                                            }
                                            break;
                                        case 1:
                                            if (pouvoirMonter && m.etageRechercher(indiceInitI, indiceInitJ) == 0) {
                                                p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                erreur = true;
                                                erreurHero = true;
                                            }

                                            if ((m.etageRechercher(indiceInitI, indiceInitJ) == 2) && IMPdescendreDeUN) {
                                                erreur = true;
                                                p.dialogPerdu("Impossible (Pouvoir Hades");
                                                erreurHero = true;
                                            }

                                            if (!erreurHero) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage1_batisseur_blanc.PNG"));
                                                erreur = false;
                                                if (pouvoirActive && m.etageRechercher(indiceInitI, indiceInitJ) == 0) {
                                                    pouvoirMonter = true;
                                                    compteur = 1;
                                                }
                                            }
                                            break;
                                        case 2:
                                            if (((m.etageRechercher(indiceInitI, indiceInitJ) == 1) || (m.etageRechercher(indiceInitI, indiceInitJ) == 2)) || (pouvoirEtage && m.etageRechercher(indiceInitI, indiceInitJ) == 0)) {
                                                if (((m.etageRechercher(indiceInitI, indiceInitJ) == 0) || m.etageRechercher(indiceInitI, indiceInitJ) == 1) && (pouvoirMonter)) {
                                                    p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                    erreur = true;
                                                    erreurHero = true;
                                                }

                                                if ((m.etageRechercher(indiceInitI, indiceInitJ) == 2) && IMPdescendreDeUN) {
                                                    erreur = true;
                                                    p.dialogPerdu("Impossible (Pouvoir Hades");
                                                    erreurHero = true;
                                                }

                                                if (!erreurHero) {
                                                    p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage2_batisseur_blanc.PNG"));
                                                    erreur = false;
                                                    if (pouvoirActive && (m.etageRechercher(indiceInitI, indiceInitJ) == 1 || m.etageRechercher(indiceInitI, indiceInitJ) == 0)) {
                                                        pouvoirMonter = true;
                                                        compteur = 1;
                                                    }
                                                }

                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }

                                            break;
                                        case 3:
                                            if (!pouvoirMonter) {
                                                if (((m.etageRechercher(indiceInitI, indiceInitJ) == 2) || (m.etageRechercher(indiceInitI, indiceInitJ) == 3)) || (pouvoirEtage && m.etageRechercher(indiceInitI, indiceInitJ) == 1)) {
                                                    p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage3_batisseur_blanc.PNG"));
                                                    erreur = false;
                                                    if (pouvoirActive) {
                                                        pouvoirMonter = true;
                                                        compteur = 1;
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 1) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage1.PNG"));
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 2) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage2.PNG"));
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 3) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage3.PNG"));
                                                    }
                                                    p.dialogPerdu("L'équipe : " + tourEquipe + " a gagné");
                                                    p.gagner();
                                                } else {
                                                    p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                    erreur = true;
                                                }
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                erreur = true;
                                            }
                                            break;
                                        case 4:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                        case 5:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                    }
                                    switch ((m.etageRechercher(indiceInitI, indiceInitJ))) {
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
                                        m.opacityModif(indiceSecondeI, indiceSecondeJ, 0);
                                        p.roseDesVents(indiceInitI, indiceInitJ, false);
                                        p.pion[indiceSecondeI][indiceSecondeJ] = p.pion[indiceInitI][indiceInitJ];
                                        p.pion[indiceInitI][indiceInitJ] = null;
                                        m.setPionSelectionner(p.pion[indiceSecondeI][indiceSecondeJ]);
                                        indiceInitJ = indiceSecondeJ;
                                        indiceInitI = indiceSecondeI;
                                        m.setDeplacementPossible(m.getDeplacementPossible() - 1);
                                        p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                        if (m.getDeplacementPossible() == 0) {
                                            p.labelMessage.setText("Constuire");
                                            pouvoirArtemis = false;
                                        }
                                        else{
                                            p.roseDesVents(indiceSecondeI,indiceSecondeJ, true);
                                            pouvoirArtemis = true;
                                        }

                                    }
                                    else{
                                        System.out.println("cc");
                                        erreurHero = false;
                                        firstSelect = false;
                                    }


                                } else {
                                    switch (m.etageRechercher(indiceSecondeI, indiceSecondeJ)) {
                                        case 0:

                                            if(pouvoirPan && (m.etageRechercher(indiceInitI, indiceInitJ) == 2)){
                                                p.dialogPerdu("GAGNER (Pouvoir Pan)");
                                                p.gagner();
                                            }

                                            if ((m.etageRechercher(indiceInitI, indiceInitJ) == 1) && IMPdescendreDeUN) {
                                                erreur = true;
                                                p.dialogPerdu("Impossible (Pouvoir Hades");
                                            } else {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage0_batisseur_rouge.PNG"));
                                                erreur = false;
                                            }
                                            break;
                                        case 1:
                                            if (pouvoirMonter && m.etageRechercher(indiceInitI, indiceInitJ) == 0) {
                                                p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                erreur = true;
                                                erreurHero = true;
                                            }

                                            if ((m.etageRechercher(indiceInitI, indiceInitJ) == 2) && IMPdescendreDeUN) {
                                                erreur = true;
                                                p.dialogPerdu("Impossible (Pouvoir Hades");
                                                erreurHero = true;
                                            }


                                            if (!erreurHero) {
                                                p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage1_batisseur_rouge.PNG"));
                                                erreur = false;
                                                if (pouvoirActive && m.etageRechercher(indiceInitI, indiceInitJ) == 0) {
                                                    pouvoirMonter = true;
                                                    compteur = 1;
                                                }
                                            }

                                            break;
                                        case 2:
                                            if (((m.etageRechercher(indiceInitI, indiceInitJ) == 1) || (m.etageRechercher(indiceInitI, indiceInitJ) == 2)) || (pouvoirEtage && m.etageRechercher(indiceInitI, indiceInitJ) == 0)) {
                                                if (((m.etageRechercher(indiceInitI, indiceInitJ) == 0) || m.etageRechercher(indiceInitI, indiceInitJ) == 1) && (pouvoirMonter)) {
                                                    p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                    erreur = true;
                                                    erreurHero = true;
                                                }

                                                if ((m.etageRechercher(indiceInitI, indiceInitJ) == 2) && IMPdescendreDeUN) {
                                                    erreur = true;
                                                    p.dialogPerdu("Impossible (Pouvoir Hades");
                                                    erreurHero = true;
                                                }

                                                if (!erreurHero) {
                                                    p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage2_batisseur_rouge.PNG"));
                                                    erreur = false;
                                                    if (pouvoirActive && (m.etageRechercher(indiceInitI, indiceInitJ) == 1 || m.etageRechercher(indiceInitI, indiceInitJ) == 0)) {
                                                        pouvoirMonter = true;
                                                        compteur = 1;
                                                    }
                                                }
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                erreur = true;
                                            }

                                            break;
                                        case 3:
                                            if (!pouvoirMonter) {
                                                if (((m.etageRechercher(indiceInitI, indiceInitJ) == 2) || (m.etageRechercher(indiceInitI, indiceInitJ) == 3)) || (pouvoirEtage && m.etageRechercher(indiceInitI, indiceInitJ) == 1)) {
                                                    p.tableauDeButton[indiceSecondeI][indiceSecondeJ].setIcon(new ImageIcon("imageSantorini/maison_etage3_batisseur_rouge.PNG"));
                                                    erreur = false;
                                                    if (pouvoirActive) {
                                                        pouvoirMonter = true;
                                                        compteur = 1;
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 1) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage1.PNG"));
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 2) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage2.PNG"));
                                                    }
                                                    if ((m.etageRechercher(indiceInitI, indiceInitJ)) == 3) {
                                                        p.tableauDeButton[indiceInitI][indiceInitJ].setIcon(new ImageIcon("imageSantorini/maison_etage3.PNG"));
                                                    }
                                                    p.dialogPerdu("L'équipe : " + tourEquipe + " a gagné");
                                                    p.gagner();
                                                } else {
                                                    p.dialogPerdu("Deplacement impossible (niveau trop bas par rapport à l'etage souhaiter)");
                                                    erreur = true;
                                                }
                                            } else {
                                                p.dialogPerdu("Deplacement impossible (Hero Athena)");
                                                erreur = true;
                                            }
                                            break;
                                        case 4:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                        case 5:
                                            p.dialogPerdu("Deplacement impossible");
                                            erreur = true;
                                            break;
                                    }
                                    switch ((m.etageRechercher(indiceInitI, indiceInitJ))) {
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
                                        m.opacityModif(indiceSecondeI, indiceSecondeJ, 0);
                                        p.roseDesVents(indiceInitI, indiceInitJ, false);
                                        p.pion[indiceSecondeI][indiceSecondeJ] = p.pion[indiceInitI][indiceInitJ];
                                        p.pion[indiceInitI][indiceInitJ] = null;
                                        m.setPionSelectionner(p.pion[indiceSecondeI][indiceSecondeJ]);
                                        indiceInitJ = indiceSecondeJ;
                                        indiceInitI = indiceSecondeI;
                                        m.setDeplacementPossible(m.getDeplacementPossible() - 1);
                                        p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                        if (m.getDeplacementPossible() == 0) {
                                            p.labelMessage.setText("Constuire");
                                            pouvoirArtemis = false;
                                        }
                                        else{
                                            p.roseDesVents(indiceSecondeI,indiceSecondeJ, true);
                                            pouvoirArtemis = true;
                                        }

                                    }
                                    else{
                                        erreurHero = false;
                                        firstSelect = false;
                                    }

                                }

                            } else {
                                p.dialogPerdu("Deplacement impossible (deplacement en rose des sables) pb diff");
                                System.out.println(diffI);
                                System.out.println(diffJ);
                            }

                        } else {
                            p.dialogPerdu("Deplacement impossible (pas sur un autre pion)");

                        }
                    }


                } else {

                    // construction

                    pouvoirActive = false;
                    pouvoirPan = false;

                    if (((p.joueur1.getHero().getNomHero() == "Hades") || (p.joueur2.getHero().getNomHero() =="Hades")) && pouvoirHades) {
                        IMPdescendreDeUN = true;
                    } else {
                        IMPdescendreDeUN = false;
                    }

                    if (((p.joueur1.getHero().getNomHero() != "Athena") || (p.joueur2.getHero().getNomHero() != "Athena")) && pouvoirMonter && compteur == 0) {
                        pouvoirMonter = false;
                    }
                    else{
                        compteur -=1;
                    }


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


                            switch (m.etageRechercher(indiceInitI, indiceInitJ)) {
                                case 0:
                                    m.setSol1(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    m.etageModif(indiceInitI, indiceInitJ, (m.etageRechercher(indiceInitI, indiceInitJ) + 1));
                                    construction = true;

                                    if (pouvoirDome == true) {
                                        m.setSolDome(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                        m.etageModif(indiceInitI, indiceInitJ, 5);
                                        pouvoirDome = false;
                                    }

                                    break;
                                case 1:
                                    m.setSol2(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    m.etageModif(indiceInitI, indiceInitJ, (m.etageRechercher(indiceInitI, indiceInitJ) + 1));
                                    construction = true;

                                    if (pouvoirDome == true) {
                                        m.setSol1Dome(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                        m.etageModif(indiceInitI, indiceInitJ, 5);
                                        pouvoirDome = false;
                                    }

                                    break;
                                case 2:
                                    m.setSol3(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    m.etageModif(indiceInitI, indiceInitJ, (m.etageRechercher(indiceInitI, indiceInitJ) + 1));
                                    construction = true;

                                    if (pouvoirDome == true) {
                                        m.setSol2Dome(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                        m.etageModif(indiceInitI, indiceInitJ, 5);
                                        pouvoirDome = false;
                                    }

                                    break;
                                case 3:
                                    m.setSol4(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                    m.etageModif(indiceInitI, indiceInitJ, (m.etageRechercher(indiceInitI, indiceInitJ) + 1));
                                    construction = true;

                                    if (pouvoirDome == true) {
                                        m.setSol4(p.tableauDeButton[indiceInitI][indiceInitJ]);
                                        m.etageModif(indiceInitI, indiceInitJ, 4);
                                        pouvoirDome = false;
                                    }

                                    break;
                                case 4:
                                    construction = false;

                                case 5:
                                    construction = false;
                            }

                            if (construction) {

                                m.setConstructionPossible(m.getConstructionPossible() - 1);
                                p.labelConstruction.setText("" + m.getConstructionPossible());

                                if (m.getConstructionPossible() == 0) {
                                    pouvoirConstruction = false;
                                    pouvoirHades = false;
                                    erreurHero = false;
                                    m.setPionSelectionner(null);
                                    m.setTour(m.getTour() + 1);
                                    p.labelTour.setText(" " + m.getTour());
                                    m.setConstructionPossible(m.getConstructionPossible() + 1);
                                    p.labelConstruction.setText("" + m.getConstructionPossible());
                                    m.setDeplacementPossible(m.getDeplacementPossible() + 1);
                                    p.labelDeplacement.setText("" + m.getDeplacementPossible());
                                    p.labelMessage.setText("Joueur 1, deplacer le pion de votre choix en cliquant dessus");
                                }


                                if (m.getTour() % 2 == 0) {
                                    p.labelJoueur.setText(p.joueur2.getNom());
                                    p.labelTeam.setText(p.joueur2.getCouleur());
                                    p.pouvoir_label.setText("Pouvoir   :  " + p.joueur2.getHero().getNomHero() + "      ");
                                    p.joueur2.getHero().getPouvoir().ActiverFALSE();
                                    p.activationPouvoir_label.setText("Mode   :  FALSE");
                                } else {
                                    p.labelJoueur.setText(p.joueur1.getNom());
                                    p.labelTeam.setText(p.joueur1.getCouleur());
                                    p.pouvoir_label.setText("Pouvoir   :  " + p.joueur1.getHero().getNomHero() + "      ");
                                    p.joueur1.getHero().getPouvoir().ActiverFALSE();
                                    p.activationPouvoir_label.setText("Mode   :  FALSE");
                                }

                                pouvoirActive = false;

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

                pouvoir = new Pouvoir(this);

                p.joueur1.getHero().setPouvoir(pouvoir);
                p.joueur2.getHero().setPouvoir(pouvoir);


                if (m.getTour() % 2 == 0) {
                    piece = new Piece("white");
                    piece.setCouleur("white");

                    if (p.pion[indiceInitI][indiceInitJ] == null) {


                        piece.setPion(p.tableauDeButton[indiceInitI][indiceInitJ]);
                        p.pion[indiceInitI][indiceInitJ] = piece;
                        m.setTour(m.getTour() + 1);
                        p.labelMessage.setText("Cliquez sur une case pour placer le " + m.getTour() + "ème pion");
                        p.labelTour.setText("initialisation " + m.getTour());

                        if (m.getTour() == 5) {
                            p.labelTour.setText(" " + m.getTour());
                            p.labelMessage.setText("Joueur 1, deplacer le pion de votre choix en cliquant dessus");
                        }


                        if (m.getTour() % 2 == 0) {
                            p.labelJoueur.setText(p.joueur2.getNom());
                            p.labelTeam.setText(p.joueur2.getCouleur());
                            p.pouvoir_label.setText("Pouvoir   :  " + p.joueur2.getHero().getNomHero() + "      ");
                        } else {
                            p.labelJoueur.setText(p.joueur1.getNom());
                            p.labelTeam.setText(p.joueur1.getCouleur());
                            p.pouvoir_label.setText("Pouvoir   :  " + p.joueur1.getHero().getNomHero() + "      ");
                        }

                    }
                } else {
                    piece = new Piece("red");
                    piece.setCouleur("red");

                    if (p.pion[indiceInitI][indiceInitJ] == null) {

                        piece.setPion(p.tableauDeButton[indiceInitI][indiceInitJ]);
                        p.pion[indiceInitI][indiceInitJ] = piece;
                        m.setTour(m.getTour() + 1);
                        p.labelMessage.setText("Cliquez sur une case pour placer le " + m.getTour() + "ème pion");
                        p.labelTour.setText("initialisation " + m.getTour());

                        if (m.getTour() == 5) {
                            p.labelTour.setText(" " + m.getTour());
                        }
                        if (m.getTour() % 2 == 0) {
                            p.labelJoueur.setText(p.joueur2.getNom());
                            p.labelTeam.setText(p.joueur2.getCouleur());
                            p.pouvoir_label.setText("Pouvoir   :  " + p.joueur2.getHero().getNomHero() + "      ");
                            pouvoirActive = false;
                        } else {
                            p.labelJoueur.setText(p.joueur1.getNom());
                            p.labelTeam.setText(p.joueur1.getCouleur());
                            p.pouvoir_label.setText("Pouvoir   :  " + p.joueur1.getHero().getNomHero() + "      ");
                            pouvoirActive = false;
                        }
                    }
                }
            }
        }
    }
}
