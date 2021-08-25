package alive.swing;

import org.springframework.stereotype.Component;
import java.awt.*;


@Component
public class SwingRunner implements Runnable {

    private final Scene scene;

    public SwingRunner(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void run() {
        EventQueue.invokeLater(() -> scene.setVisible(true));
    }
}
