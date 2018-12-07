import javax.sound.sampled.Control;

public class Pouvoir {

    Controller c;

    public Pouvoir(){

    }

    public Pouvoir(Controller c){
    this.c = c;
    }

    public int utiliserPouvoir(String nomHeroPosseder) {

        switch (nomHeroPosseder) {


            case "Achilles":
                System.out.println("deplacement de deux");
                break;

            case "Aeolus":
                System.out.println("deplacement de 3");
                break;

            case "Artemis":
                System.out.println("POUVOIR Artemis: Vous pouvez vous deplacez deux fois");
                c.m.setDeplacementPossible(c.m.getDeplacementPossible() + 1);
                c.ActiverPouvoir();
                c.p.labelDeplacement.setText("" + c.m.getDeplacementPossible());

                break;

        }

        return 0;

    }

}
