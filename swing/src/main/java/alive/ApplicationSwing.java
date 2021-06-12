package alive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationSwing {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationSwing.class, args);
        var viw = context.getBean(View.class);
    }
}
