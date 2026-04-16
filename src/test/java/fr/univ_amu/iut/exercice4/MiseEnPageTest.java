package fr.univ_amu.iut.exercice4;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
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

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laFenetreEstVisible(FxRobot robot) {
    assertThat(stage.isShowing())
        .as("le Stage doit être affiché — appelle show() à la fin de start()")
        .isTrue();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leRootEstUnBorderPane(FxRobot robot) {
    assertThat(stage.getScene().getRoot())
        .as("la racine de la Scene doit être un BorderPane")
        .isInstanceOf(BorderPane.class);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leMenuBarEstEnHaut(FxRobot robot) {
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    assertThat(root.getTop())
        .as("le MenuBar doit être placé dans la zone top() du BorderPane")
        .isInstanceOf(MenuBar.class);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesDeuxChampsDeSaisieExistent(FxRobot robot) {
    assertThat(robot.lookup(".text-field").queryAll())
        .as("le formulaire doit contenir au moins 2 TextField")
        .hasSizeGreaterThanOrEqualTo(2);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesBoutonsValiderEtAnnulerExistent(FxRobot robot) {
    boolean valider =
        robot.lookup(".button").queryAll().stream()
            .anyMatch(n -> n instanceof Button && "Valider".equals(((Button) n).getText()));
    boolean annuler =
        robot.lookup(".button").queryAll().stream()
            .anyMatch((Node n) -> n instanceof Button && "Annuler".equals(((Button) n).getText()));
    assertThat(valider).as("bouton Valider attendu").isTrue();
    assertThat(annuler).as("bouton Annuler attendu").isTrue();
  }
}
