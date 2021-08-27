package alive.fx;

import alive.JavaFxApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@Component
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class BootableJavaFxApplication extends Application {

    @Autowired
    private FieldMatrix fieldMatrix;

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(JavaFxApplication.class)
                .web(WebApplicationType.NONE)
                .run();
        applicationContext
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) {
        var scene = new Scene(new Group(fieldMatrix));
        primaryStage.setTitle("Alive JavaFX");
        primaryStage.setIconified(false);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        fieldMatrix.simulate();
    }

    @Override
    public void stop() {
        applicationContext.stop();
        Platform.exit();
    }
}
