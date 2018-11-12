package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class Plateau extends Application {

    @Override
    public void start(Stage primaryStage){
        int I = 5;

        GridPane grid = new GridPane();
        Controller controller;
        Button button;

        Image sol = new Image ("/imageSantorini/Sol.PNG",150,150,true,true);
        Image sol2 = new Image ("/imageSantorini/Sol2.PNG",150,150,true,true);
        Image sol3 = new Image ("/imageSantorini/Sol3.PNG",150,150,true,true);
        Image sol4 = new Image ("/imageSantorini/Sol4.PNG",150,150,true,true);

        Image base = new Image ("/imageSantorini/Maison.PNG",150,150,true,true);
        Image base2 = new Image ("/imageSantorini/Maison2.PNG",150,150,true,true);
        Image base3 = new Image ("/imageSantorini/Maison3.PNG",150,150,true,true);
        Image base4 = new Image ("/imageSantorini/Maison4.PNG",150,150,true,true);

        Image[] imageBase = new Image[]{base, base2, base3, base4};

        Image[] image = new Image[]{sol, sol2, sol3, sol4};

        //Creation de la grille
        for (int row = 0; row < I ; row++) {
            for (int col = 0; col < I; col++) {
                button = new Button();
                controller = new Controller(button);
                button.setMaxSize(150,150);
                button.setMinSize(150,150);
                button.setId("button" + String.valueOf(row) + "-" + String.valueOf(col));

                //image pour les bords
                if (row == 4){
                    button.setGraphic(new ImageView(image[3]));
                }
                if (row == 0){
                    button.setGraphic(new ImageView(image[1]));
                }
                if (col == 0){
                    button.setGraphic(new ImageView(image[0]));
                }
                if (col == 4){
                    button.setGraphic(new ImageView(image[3]));
                }
                //image aléatoire au milieu
                else if (row !=4 && row != 0 && col != 0){
                    Random random = new Random();
                    button.setGraphic(new ImageView(image[random.nextInt(3)]));
                }
                grid.add(button,col,row);
            }
        }

        Scene scene = new Scene(grid, I*150, I*150);
        primaryStage.setTitle("Santorini");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}