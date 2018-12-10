import javax.sound.sampled.Control;

public class Pouvoir {

    Controller c;
    private boolean activer = false;

    // "default", "Achilles", "Aeolus", "Aphrodite", "Apollo", "Ares", "Artemis", "Atalanta", "Athena", "Atlas", "Bellerophon", "Bia",

    public Pouvoir() {
        this.activer = false;
    }

    public Pouvoir(Controller c) {
        this.c = c;
        this.activer=false;
    }

    public int utiliserPouvoir(String nomHeroPosseder) {



        if (c.p.joueur1.getHero().getPouvoir().isActiver().equals("FALSE") || c.p.joueur2.getHero().getPouvoir().isActiver().equals("FALSE")) {

            c.p.joueur1.getHero().getPouvoir().setActiver(true);
            c.p.joueur2.getHero().getPouvoir().setActiver(true);


        switch (nomHeroPosseder) {

                case "Achilles":
                    System.out.println("POUVOIR Achilles");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;

                case "Aeolus":
                    System.out.println("POUVOIR Aeolus");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;

                case "Aphrodite":

                    break;

                case "Apollo":
                    break;

                case "Ares":
                    break;

                case "Artemis":
                    System.out.println("POUVOIR Artemis: Vous pouvez vous deplacez deux fois");
                    c.m.setDeplacementPossible(c.m.getDeplacementPossible() + 1);
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.labelDeplacement.setText("" + c.m.getDeplacementPossible());
                    break;
                case "Atalanta":
                    break;

                case "Athena":
                    System.out.println("POUVOIR Athena: Si un de vos Bâtisseur est monté d'un niveau pendant votre dernière Action Mouvement, aucun autre Bâtisseur ne peut monnter d'un niveau jusqu'à votre prochain tour");
                    c.pouvoirActive = true;
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;
                case "Atlas":
                    System.out.println("POUVOIR Atlas: Vous pouvez placer un dome");
                    c.pouvoirDome = true;
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;
                case "Bellerophon":
                    System.out.println("POUVOIR Bellerophon: Vous pouvez monter de deux étages");
                    c.pouvoirEtage = true;
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;
                case "Charon":
                    break;
                case "Charybdis":
                    break;
                case "Chronos":
                    System.out.println("POUVOIR Chronos: Vous pouvez gagner si vous avez au moins 5 tours terminées");
                    int compteur = 0;
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (c.m.etageRechercher(i, j) == 4) {
                                compteur++;
                            }

                        }

                    }
                    if (compteur >= 5) {
                        System.out.println("Gagner : 5 tours terminées");
                        c.p.dialogPerdu("GAGNER (Pouvoir Chronos)");
                        c.p.gagner();
                    } else {
                        System.out.println("pour gaggner il faut au moins 5 tours terminées");

                    }
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;
                case "Clio":
                    break;
                case "Demeter":
                    System.out.println("POUVOIR Demeter: Vous pouvez performer l'Action Construire 2 fois, sur des cases différentes");
                    if(!c.pouvoirConstruction) {
                        c.m.setConstructionPossible(c.m.getConstructionPossible() + 1);
                        c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                        c.p.labelConstruction.setText("" + c.m.getConstructionPossible());
                        c.pouvoirConstruction = true;
                    }
                    break;
                case "Dionysus":
                    break;
                case "Eros":
                    break;
                case "Gaia":
                    break;
                case "Graea":
                    break;
                case "Hades":
                    System.out.println("POUVOIR Hades: Les Bâtisseurs ennemis ne peuvent pas descendre d'exactement 1 niveau pendant un Action mouvement");
                    c.pouvoirHades = true;
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    break;
                case "Hecate":
                    break;
                case "Hera":
                    break;
                case "Heraclas":
                    break;
                case "Hermes":
                    break;
                case "Limos":
                    break;
                case "Medusa":
                    break;
                case "Morpheus":
                    break;
                case "Nemesis":
                    break;
                case "Pan":
                    System.out.println("POUVOIR Pan: Vous gagnez si vous descendez exactement deux niveaux");
                    c.p.activationPouvoir_label.setText("Mode   :  TRUE");
                    c.pouvoirPan = true;
                    break;
                case "Persephone":
                    break;
                case "Polyphemus":
                    break;
                case "Poseidon":
                    break;
                case "Selene":
                    break;
                case "Theseus":
                    break;
                case "Triton":
                    break;


            }
        }

        return 0;

    }

    public String isActiver() {
        if(this.activer == false){
            return "FALSE";
        }
        else{
            return "TRUE";
        }
    }

    public void setActiver(boolean activer) {
        this.activer = activer;
    }

    public void ActiverFALSE() {
        this.activer = false;
    }
    public void ActiverTRUE() {
        this.activer = true;
    }

}
