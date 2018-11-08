package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.util.Random;


public class Plateau extends Application {

    @Override
    public void start(Stage primaryStage){
        int i = 5;
        GridPane grid = new GridPane();

        ImageView  sol = new ImageView ("/imageSantorini/Sol.png");
        ImageView  sol2 = new ImageView ("/imageSantorini/Sol2.png");
        ImageView  sol3 = new ImageView ("/imageSantorini/Sol3.png");
        ImageView  sol4 = new ImageView ("/imageSantorini/Sol4.png");

        ImageView[] image = {sol, sol2, sol3, sol4};

        for (int j = 0; j < image.length; j++) {
            image[j].setFitHeight(200);
            image[j].setFitWidth(200);
        }

        //Creation de la grille
        for (int row = 0; row < i ; row++) {
            for (int col = 0; col < i; col++) {
                Button button = new Button();
                button.setMaxSize(200,200);
                button.setMinSize(200,200);

                //image pour les bords
                if (row == 4){
                    button.setGraphic(image[3]);
                }
                if (row == 0){
                    button.setGraphic(image[1]);
                }
                if (col == 0){
                    button.setGraphic(image[0]);
                }
                if (col == 4){
                    button.setGraphic(image[2]);
                }
                //image aléatoire au milieu
                else if (row !=4 && row != 0 && col != 0){
                    Random random = new Random();
                    button.setGraphic(image[random.nextInt(4)]);
                }
                grid.add(button,col,row);
            }
        }

        Scene scene = new Scene(grid, i*200, i*200);
        primaryStage.setTitle("Santorini");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
