package alive;

public class Main {

    public static void main(String[] args) {

        for (var i = 0; i < 100; ++i) {
            System.out.println(Randomize.next(1, 3));
        }
    }
}