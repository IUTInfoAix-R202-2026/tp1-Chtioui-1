package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Application JavaFX principale.
 *
 * Cette classe sert de point d'entrée pour vérifier que l'environnement
 * JavaFX est correctement configuré.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("JavaFX fonctionne !");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("TP1 - IUT Aix-Marseille");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
