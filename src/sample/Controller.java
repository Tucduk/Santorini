package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    private int etage = 0;
    Joueur joueur;
    private static int tour = 0;

    Image base = new Image("/imageSantorini/Maison.PNG", 150, 150, true, true);
    Image base2 = new Image("/imageSantorini/Maison2.PNG", 150, 150, true, true);
    Image base3 = new Image("/imageSantorini/Maison3.PNG", 150, 150, true, true);
    Image base4 = new Image("/imageSantorini/Maison4.PNG", 150, 150, true, true);

    Image[] imageBase = {base, base2, base3, base4};

    public Controller(Button button) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tour++;
                    System.out.println(tour);
                    if (tour>4){
                        switch (etage) {
                            case 0:
                                button.setGraphic(new ImageView(imageBase[0]));
                                etage++;
                                break;
                            case 1:
                                button.setGraphic(new ImageView(imageBase[1]));
                                etage++;
                                break;
                            case 2:
                                button.setGraphic(new ImageView(imageBase[2]));
                                etage++;
                                break;
                            case 3:
                                button.setGraphic(new ImageView(imageBase[3]));
                                etage++;
                                break;
                        }
                    }else{
                        if (tour%2 == 0){
                            joueur = new Pion("Joueur1",1);
                            ((Pion) joueur).setCouleur("white");
                            ((Pion) joueur).setPion(button);
                        }else{
                            joueur = new Pion("Joueur2",2);
                            ((Pion) joueur).setCouleur("black");
                            ((Pion) joueur).setPion(button);
                        }
                    }
                }
            });
    }
}
