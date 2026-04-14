package fr.univ_amu.iut.exercice6;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/** Tests de l'exercice 6 — Palette de couleurs. */
@ExtendWith(ApplicationExtension.class)
class PaletteTest {

  @Start
  void start(Stage stage) throws Exception {
    new Palette().start(stage);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesTroisBoutonsExistent(FxRobot robot) {
    assertThat(robot.lookup("#btn-rouge").queryAs(Button.class)).isNotNull();
    assertThat(robot.lookup("#btn-vert").queryAs(Button.class)).isNotNull();
    assertThat(robot.lookup("#btn-bleu").queryAs(Button.class)).isNotNull();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerRougeMetLaZoneEnRouge(FxRobot robot) {
    robot.clickOn("#btn-rouge");
    Pane zone = robot.lookup("#zone").queryAs(Pane.class);
    assertThat(zone.getStyle())
        .as("la zone doit contenir une règle background-color rouge après un clic")
        .contains("red");
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerIncremenceLeCompteurCorrespondant(FxRobot robot) {
    robot.clickOn("#btn-vert");
    robot.clickOn("#btn-vert");

    Label compteurs = robot.lookup("#compteurs").queryAs(Label.class);
    assertThat(compteurs.getText()).contains("Vert: 2");
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesCompteursSontIndependants(FxRobot robot) {
    robot.clickOn("#btn-rouge");
    robot.clickOn("#btn-rouge");
    robot.clickOn("#btn-bleu");

    Label compteurs = robot.lookup("#compteurs").queryAs(Label.class);
    assertThat(compteurs.getText()).contains("Rouge: 2");
    assertThat(compteurs.getText()).contains("Vert: 0");
    assertThat(compteurs.getText()).contains("Bleu: 1");
  }
}
