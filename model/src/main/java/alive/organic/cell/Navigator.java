package alive.organic.cell;

import alive.organic.Mortal;


public interface Navigator extends Mortal {

    void goAhead();

    void rotate(int steps);
}
