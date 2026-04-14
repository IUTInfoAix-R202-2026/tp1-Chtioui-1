package fr.univ_amu.iut.exercice2;

import static org.assertj.core.api.Assertions.assertThat;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/** Tests de l'exercice 2 — Stage personnalisé. */
@ExtendWith(ApplicationExtension.class)
class StagePersonnaliseTest {

  private Stage stage;

  @Start
  void start(Stage stage) throws Exception {
    this.stage = stage;
    new StagePersonnalise().start(stage);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leTitreEstDefini(FxRobot robot) {
    assertThat(stage.getTitle()).isEqualTo("Ma fenêtre personnalisée");
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void lesDimensionsSontDefinies(FxRobot robot) {
    assertThat(stage.getWidth()).isEqualTo(500.0);
    assertThat(stage.getHeight()).isEqualTo(300.0);
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void laFenetreNestPasRedimensionnable(FxRobot robot) {
    assertThat(stage.isResizable()).isFalse();
  }

  @Disabled("Retire cette annotation pour activer le test")
  @Test
  void leStyleEstUndecorated(FxRobot robot) {
    assertThat(stage.getStyle()).isEqualTo(StageStyle.UNDECORATED);
  }
}
