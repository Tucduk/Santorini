package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Appli extends Application {

    public static Fenetre fenetre;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Santorini");
        Group root = new Group();
        Plateau plateau = new Plateau();
        fenetre = new Fenetre(plateau);
        root.getChildren().add(fenetre);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
