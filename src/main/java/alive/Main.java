package alive;

import alive.field.MainField;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var field = new MainField(30, 30);
        field.start();
    }
}