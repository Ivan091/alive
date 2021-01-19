package com.model.simulation.entities.alive.bot.direction;

import com.model.simulation.entities.qualities.direction.LookDirection;
import com.model.simulation.entities.qualities.position.Position;
import com.model.simulation.entities.qualities.position.PositionEntity;

public class BotLookDirection implements LookDirection {

    private static final Position[] relativePositions = new Position[]{
            new PositionEntity(1, 0),
            new PositionEntity(1, 1),
            new PositionEntity(0, 1),
            new PositionEntity(-1, 1),
            new PositionEntity(-1, 0),
            new PositionEntity(-1, -1),
            new PositionEntity(0, -1),
            new PositionEntity(1, -1),
    };

    private int directionNumber;

    /**
     * each look direction has unique number:
     * <p>{@code 3 2 1}</p>
     * <p>{@code 4 _ 0}</p>
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

        if (directionNumber < 0) {
            directionNumber += 8;
        }
    }

    @Override
    public Position getLookingPos(Position currentPosition) {

        var lookingRelativePos = relativePositions[directionNumber];
        return new PositionEntity(
                currentPosition.getX() + lookingRelativePos.getX(),
                currentPosition.getY() + lookingRelativePos.getY());
    }

    @Override
    public LookDirection opposite() {

        var newDir = this.replicate();
        newDir.rotate(4);
        return newDir;
    }

    @Override
    public LookDirection replicate() {

        return new BotLookDirection(directionNumber);
    }
}












