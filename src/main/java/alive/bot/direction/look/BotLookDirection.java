package alive.bot.direction.look;

import alive.bot.position.BotPosition;
import alive.bot.position.Position;

import java.util.ArrayList;
import java.util.List;

public class BotLookDirection implements LookDirection {

    private static final List<Position> relativePositions = new ArrayList<>(8);

    static {
        relativePositions.add(new BotPosition(1, 1));
        relativePositions.add(new BotPosition(0, 1));
        relativePositions.add(new BotPosition(-1, 1));
        relativePositions.add(new BotPosition(-1, 0));
        relativePositions.add(new BotPosition(-1, -1));
        relativePositions.add(new BotPosition(0, -1));
        relativePositions.add(new BotPosition(1, -1));
        relativePositions.add(new BotPosition(1, 0));
    }

    private int directionNumber;

    /**
     * each look direction has unique number:
     * <p>{@code 2 1 0}</p>
     * <p>{@code 4 _ 8}</p>
     * <p>{@code 5 6 7}</p>
     */
    public BotLookDirection(int directionNumber) {

        this.directionNumber = directionNumber;
    }

    public BotLookDirection() {

    }

    @Override
    public void rotate(int rotationSteps) {

        directionNumber = (directionNumber + rotationSteps) % 8;
    }

    @Override
    public Position getLookingPos(Position currentPosition) {

        var lookingRelativePos = relativePositions.get(directionNumber);
        return new BotPosition(
                currentPosition.getX() + lookingRelativePos.getX(),
                currentPosition.getY() + lookingRelativePos.getY());
    }

    @Override
    public LookDirection getOpposite() {

        var newDir = this.replicate();
        newDir.rotate(4);
        return newDir;
    }

    @Override
    public LookDirection replicate() {

        return new BotLookDirection(directionNumber);
    }
}












