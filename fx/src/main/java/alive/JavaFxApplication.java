package alive;

import alive.fx.BootableJavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaFxApplication {

    public static void main(String[] args) {
        Application.launch(BootableJavaFxApplication.class, args);
    }
}