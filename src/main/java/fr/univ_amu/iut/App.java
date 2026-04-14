package fr.univ_amu.iut;

import fr.univ_amu.iut.exercice1.PremiereFenetre;
import fr.univ_amu.iut.exercice2.StagePersonnalise;
import fr.univ_amu.iut.exercice3.PremiereScene;
import fr.univ_amu.iut.exercice4.MiseEnPage;
import fr.univ_amu.iut.exercice5.EvenementsBouton;
import fr.univ_amu.iut.exercice6.Palette;
import java.util.function.Supplier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Lanceur du TP1. Affiche un menu avec un bouton par exercice ; cliquer lance l'exercice
 * correspondant dans une nouvelle fenêtre.
 *
 * <p>Point d'entrée par défaut de {@code ./mvnw javafx:run}. Les étudiants peuvent aussi lancer
 * chaque exercice directement depuis leur IDE en faisant clic droit → Run sur la classe de
 * l'exercice concerné.
 */
public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    Label titre = new Label("TP1 — Bases JavaFX");
    titre.setId("titre-tp1");
    titre.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    VBox root = new VBox(10);
    root.setPadding(new Insets(20));
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(titre);
    root.getChildren().add(bouton("Exercice 1 — Première fenêtre", PremiereFenetre::new));
    root.getChildren().add(bouton("Exercice 2 — Stage personnalisé", StagePersonnalise::new));
    root.getChildren().add(bouton("Exercice 3 — Première Scene", PremiereScene::new));
    root.getChildren().add(bouton("Exercice 4 — Mise en page", MiseEnPage::new));
    root.getChildren().add(bouton("Exercice 5 — Événements bouton", EvenementsBouton::new));
    root.getChildren().add(bouton("Exercice 6 — Palette", Palette::new));

    primaryStage.setTitle("TP1 - Bases JavaFX — Lanceur");
    primaryStage.setScene(new Scene(root, 420, 340));
    primaryStage.show();
  }

  private Button bouton(String libelle, Supplier<Application> fabrique) {
    Button btn = new Button(libelle);
    btn.setMaxWidth(Double.MAX_VALUE);
    btn.setOnAction(
        e -> {
          try {
            fabrique.get().start(new Stage());
          } catch (Exception ex) {
            // En cas d'erreur (exercice non encore implémenté par l'étudiant),
            // on affiche un message dans la console et on ne plante pas le lanceur.
            System.err.println("Impossible de lancer " + libelle + " : " + ex.getMessage());
          }
        });
    return btn;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
