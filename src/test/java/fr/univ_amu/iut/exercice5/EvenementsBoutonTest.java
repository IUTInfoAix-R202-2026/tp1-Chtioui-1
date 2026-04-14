package fr.univ_amu.iut.exercice5;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Test d'intégration de l'exercice 5 : vérifie que cliquer sur le bouton incrémente le label
 * affichant le compteur.
 *
 * <p>Ce test valide le comportement "bouton cliqué → label mis à jour" sans se soucier du style
 * d'écouteur utilisé par l'étudiant (classe nommée, classe anonyme ou lambda). Les trois styles,
 * s'ils sont bien écrits, produisent le même résultat.
 */
@ExtendWith(ApplicationExtension.class)
class EvenementsBoutonTest {

  @Start
  void start(Stage stage) throws Exception {
    new EvenementsBouton().start(stage);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void troisClicsAffichent3Clics(FxRobot robot) {
    robot.clickOn("#bouton-clique-moi");
    robot.clickOn("#bouton-clique-moi");
    robot.clickOn("#bouton-clique-moi");

    Label compteur = robot.lookup("#compteur").queryAs(Label.class);
    assertThat(compteur.getText()).isEqualTo("3 clics");
  }
}
