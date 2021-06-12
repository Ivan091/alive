package alive;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class ApplicationSwing {

    public static void main(String[] args) {
        var context = new SpringApplicationBuilder(ApplicationSwing.class)
                .web(WebApplicationType.NONE)
                .run(args);
        var view = context.getBean(View.class);
    }
}
