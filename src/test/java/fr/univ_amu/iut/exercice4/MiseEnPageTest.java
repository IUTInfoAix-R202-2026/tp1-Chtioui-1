package fr.univ_amu.iut.exercice4;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/** Tests de l'exercice 4 — Mise en page d'un formulaire. */
@ExtendWith(ApplicationExtension.class)
class MiseEnPageTest {

  private Stage stage;

  @Start
  void start(Stage stage) throws Exception {
    this.stage = stage;
    new MiseEnPage().start(stage);
  }

  // --- Étape 1 : afficher la fenêtre ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laFenetreEstVisible(FxRobot robot) {
    assertThat(stage.isShowing())
        .as("le Stage doit être affiché — appelle show() à la fin de start()")
        .isTrue();
  }

  // --- Étape 2 : créer le squelette BorderPane + Scene ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leRootEstUnBorderPane(FxRobot robot) {
    assertThat(stage.getScene().getRoot())
        .as("la racine de la Scene doit être un BorderPane")
        .isInstanceOf(BorderPane.class);
  }

  // --- Étape 3 : ajouter un MenuBar dans la zone top ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leMenuBarEstEnHaut(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    assertThat(root.getTop())
        .as("la zone top du BorderPane doit contenir un MenuBar")
        .isInstanceOf(MenuBar.class);
  }

  // --- Étape 4 : ajouter deux Menu au MenuBar ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leMenuBarContientDeuxMenus(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    MenuBar menuBar = (MenuBar) root.getTop();
    assertThat(menuBar.getMenus())
        .as("le MenuBar doit contenir au moins 2 menus")
        .hasSizeGreaterThanOrEqualTo(2);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesMenusOntLesBonsNoms(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    MenuBar menuBar = (MenuBar) root.getTop();
    assertThat(menuBar.getMenus().get(0).getText())
        .as("le premier menu doit s'appeler 'Fichier'")
        .isEqualTo("Fichier");
    assertThat(menuBar.getMenus().get(1).getText())
        .as("le deuxième menu doit s'appeler 'Aide'")
        .isEqualTo("Aide");
  }

  // --- Étape 5 : ajouter un GridPane dans la zone center ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leGridPaneEstAuCentre(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    assertThat(root.getCenter())
        .as("la zone center du BorderPane doit contenir un GridPane")
        .isInstanceOf(GridPane.class);
  }

  // --- Étape 6 : ajouter les labels dans le GridPane ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesLabelsNomEtEmailExistent(FxRobot robot) {
    boolean nom =
        robot.lookup(".label").queryAll().stream()
            .anyMatch(n -> n instanceof Label && "Nom :".equals(((Label) n).getText()));
    boolean email =
        robot.lookup(".label").queryAll().stream()
            .anyMatch(n -> n instanceof Label && "Email :".equals(((Label) n).getText()));
    assertThat(nom).as("un Label 'Nom :' doit être présent").isTrue();
    assertThat(email).as("un Label 'Email :' doit être présent").isTrue();
  }

  // --- Étape 7 : ajouter les TextField dans le GridPane ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesDeuxChampsDeSaisieExistent(FxRobot robot) {
    assertThat(robot.lookup(".text-field").queryAll())
        .as("le formulaire doit contenir au moins 2 TextField")
        .hasSizeGreaterThanOrEqualTo(2);
  }

  // --- Étape 8 : ajouter un HBox dans la zone bottom ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leHBoxEstEnBas(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    assertThat(root.getBottom())
        .as("la zone bottom du BorderPane doit contenir un HBox")
        .isInstanceOf(HBox.class);
  }

  // --- Étape 9 : ajouter le bouton Valider ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leBoutonValiderExiste(FxRobot robot) {
    boolean valider =
        robot.lookup(".button").queryAll().stream()
            .anyMatch(n -> n instanceof Button && "Valider".equals(((Button) n).getText()));
    assertThat(valider).as("un bouton 'Valider' doit être présent").isTrue();
  }

  // --- Étape 10 : ajouter le bouton Annuler ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leBoutonAnnulerExiste(FxRobot robot) {
    boolean annuler =
        robot.lookup(".button").queryAll().stream()
            .anyMatch(n -> n instanceof Button && "Annuler".equals(((Button) n).getText()));
    assertThat(annuler).as("un bouton 'Annuler' doit être présent").isTrue();
  }
}
