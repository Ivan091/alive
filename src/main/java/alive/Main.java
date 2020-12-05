package alive;

import alive.field.MainField;

public class Main {

    public static void main(String[] args) {

        start();
        var a = 32;
        System.out.println(a / 8);
        System.out.println(a / 16);
    }

    public static void start() {
        var field = new MainField(70, 70);
        field.start();
    }

}