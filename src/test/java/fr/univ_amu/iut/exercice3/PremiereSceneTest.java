package fr.univ_amu.iut.exercice3;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/** Tests de l'exercice 3 — Première Scene avec un Label. */
@ExtendWith(ApplicationExtension.class)
class PremiereSceneTest {

  private Stage stage;

  @Start
  void start(Stage stage) throws Exception {
    this.stage = stage;
    new PremiereScene().start(stage);
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
  void laSceneExiste(FxRobot robot) {
    assertThat(stage.getScene())
        .as("le Stage doit avoir une Scene attachée via setScene()")
        .isNotNull();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leLabelEstAffiche(FxRobot robot) {
    Label label = robot.lookup("Bonjour, JavaFX !").queryAs(Label.class);
    assertThat(label).as("un Label avec le texte attendu doit être visible").isNotNull();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leLabelEstAuCentreDuBorderPane(FxRobot robot) {
    assertThat(stage.getScene().getRoot())
        .as("la racine de la Scene doit être un BorderPane")
        .isInstanceOf(BorderPane.class);
    BorderPane root = (BorderPane) stage.getScene().getRoot();
    assertThat(root.getCenter()).as("le Label doit être placé au centre").isInstanceOf(Label.class);
  }
}
