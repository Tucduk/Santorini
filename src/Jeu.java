import java.util.*;

public class Jeu {
    static final Scanner input = new Scanner(System.in);

    public static String getCoordonnéePiece(String camp) {
        System.out.println(camp.concat(" c'est à vous, qu'elle pièce vous voulez déplacer ? "));
        return input.nextLine();
    }

    public static String getCoordonnéeDeplacement() {
        System.out.println("Où voulez vous déplacer votre pièce ?");
        return input.nextLine();
    }


    public static void main(String[] args)


    {

        Model m = new Model();
        ControlGroup g = new ControlGroup(m);
        Plateau p = new Plateau(m);


    }


}
