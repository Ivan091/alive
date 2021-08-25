package alive.swing;

import org.springframework.stereotype.Component;
import javax.swing.*;


@Component
public class Scene extends JFrame {

    public Scene(Field field) {
        add(field);
        setTitle("Alive Swing");
        pack();
        field.startGame();
    }
}
