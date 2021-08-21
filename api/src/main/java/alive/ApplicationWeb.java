package alive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@EnableWebSocketMessageBroker
public class ApplicationWeb {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWeb.class, args);
    }
}
