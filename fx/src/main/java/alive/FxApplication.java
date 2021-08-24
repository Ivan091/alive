package alive;

import alive.fx.MainScene;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FxApplication {

    public static void main(String[] args) {
        Application.launch(MainScene.class, args);
    }
}
