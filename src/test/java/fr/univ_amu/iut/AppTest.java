package fr.univ_amu.iut;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Smoke test : vérifie que JavaFX rend bien la scène et que les
 * --add-opens nécessaires à TestFX (cf. pom.xml argLine) sont OK.
 */
@ExtendWith(ApplicationExtension.class)
class AppTest {

    @Start
    void start(Stage stage) {
        new App().start(stage);
    }

    @Test
    void labelShouldBeDisplayed(FxRobot robot) {
        Label label = robot.lookup("JavaFX fonctionne !").queryAs(Label.class);
        assertThat(label).isNotNull();
        assertThat(label.getText()).isEqualTo("JavaFX fonctionne !");
    }
}
