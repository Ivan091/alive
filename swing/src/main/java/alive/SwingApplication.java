package alive;

import alive.swing.SwingRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class SwingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SwingApplication.class).web(WebApplicationType.NONE).headless(false).run(args)
                .getBean(SwingRunner.class).run();
    }
}
