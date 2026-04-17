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

/** Tests de l'exercice 6 — Palette de couleurs (capstone). */
@ExtendWith(ApplicationExtension.class)
class PaletteTest {

  private Stage stage;

  @Start
  void start(Stage stage) throws Exception {
    this.stage = stage;
    new Palette().start(stage);
  }

  // --- Étape 1 : afficher la fenêtre ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laFenetreEstVisible(FxRobot robot) {
    assertThat(stage.isShowing())
        .as("le Stage doit être affiché — appelle show() à la fin de start()")
        .isTrue();
  }

  // --- Étape 2 : créer une Scene ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laSceneExiste(FxRobot robot) {
    assertThat(stage.getScene())
        .as("le Stage doit avoir une Scene attachée via setScene()")
        .isNotNull();
  }

  // --- Étape 3 : ajouter les trois boutons ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesTroisBoutonsExistent(FxRobot robot) {
    assertThat(robot.lookup("#btn-rouge").queryAs(Button.class))
        .as("un Button avec l'id 'btn-rouge' doit être présent")
        .isNotNull();
    assertThat(robot.lookup("#btn-vert").queryAs(Button.class))
        .as("un Button avec l'id 'btn-vert' doit être présent")
        .isNotNull();
    assertThat(robot.lookup("#btn-bleu").queryAs(Button.class))
        .as("un Button avec l'id 'btn-bleu' doit être présent")
        .isNotNull();
  }

  // --- Étape 4 : ajouter la zone de couleur ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laZoneDeCouleurExiste(FxRobot robot) {
    Pane zone = robot.lookup("#zone").queryAs(Pane.class);
    assertThat(zone).as("un Pane avec l'id 'zone' doit être présent au centre").isNotNull();
  }

  // --- Étape 5 : ajouter le label des compteurs ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leLabelCompteursExiste(FxRobot robot) {
    Label compteurs = robot.lookup("#compteurs").queryAs(Label.class);
    assertThat(compteurs).as("un Label avec l'id 'compteurs' doit être présent en bas").isNotNull();
  }

  // --- Étape 6 : cliquer Rouge change la couleur de fond ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerRougeMetLaZoneEnRouge(FxRobot robot) {
    robot.clickOn("#btn-rouge");
    Pane zone = robot.lookup("#zone").queryAs(Pane.class);
    assertThat(zone.getStyle())
        .as("la zone doit contenir une règle background-color rouge après un clic")
        .contains("red");
  }

  // --- Étape 7 : cliquer Vert change la couleur de fond ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerVertMetLaZoneEnVert(FxRobot robot) {
    robot.clickOn("#btn-vert");
    Pane zone = robot.lookup("#zone").queryAs(Pane.class);
    assertThat(zone.getStyle())
        .as("la zone doit contenir une règle background-color verte après un clic")
        .contains("green");
  }

  // --- Étape 8 : cliquer Bleu change la couleur de fond ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerBleuMetLaZoneEnBleu(FxRobot robot) {
    robot.clickOn("#btn-bleu");
    Pane zone = robot.lookup("#zone").queryAs(Pane.class);
    assertThat(zone.getStyle())
        .as("la zone doit contenir une règle background-color bleue après un clic")
        .contains("blue");
  }

  // --- Étape 9 : cliquer incrémente le compteur correspondant ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void cliquerIncrementeLeCompteurCorrespondant(FxRobot robot) {
    robot.clickOn("#btn-vert");
    robot.clickOn("#btn-vert");

    Label compteurs = robot.lookup("#compteurs").queryAs(Label.class);
    assertThat(compteurs.getText())
        .as("après 2 clics sur Vert, le label doit contenir 'Vert: 2'")
        .contains("Vert: 2");
  }

  // --- Étape 10 : les compteurs sont indépendants ---

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesCompteursSontIndependants(FxRobot robot) {
    robot.clickOn("#btn-rouge");
    robot.clickOn("#btn-rouge");
    robot.clickOn("#btn-bleu");

    Label compteurs = robot.lookup("#compteurs").queryAs(Label.class);
    assertThat(compteurs.getText()).as("Rouge doit valoir 2").contains("Rouge: 2");
    assertThat(compteurs.getText()).as("Vert doit valoir 0 (aucun clic)").contains("Vert: 0");
    assertThat(compteurs.getText()).as("Bleu doit valoir 1").contains("Bleu: 1");
  }
}
