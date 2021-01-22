package com.domain.simulation.field;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.Alive;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import com.domain.simulation.entities.lifeless.LifelessBotBody;
import com.domain.simulation.field.matrix.MatrixEntities;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class FieldLiveTest {

    private final Field field = new FieldLive(13, 11);
    private final MatrixEntities matrix = field.cellsMatrix();
    private Position positionEntity = new PositionEntity(1, 1);
    private Alive liveMock = mock(Alive.class);
    private Entity body = new LifelessBotBody(positionEntity, new EnergyEntity(0));

    @BeforeEach
    void setBotMock() {
        when(liveMock.isAlive()).thenReturn(true);
        when(liveMock.position()).thenReturn(positionEntity);
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(13, field.width());
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(11, field.height());
    }

    @Test
    void getCellsMatrix() {
        Assertions.assertNotNull(matrix);
        Assertions.assertEquals(field.width(), matrix.getWidth());
        Assertions.assertEquals(field.height(), matrix.getHeight());
    }

    @Test
    void putEntity() {
        var body = new LifelessBotBody(positionEntity, new EnergyEntity(0));
        field.putEntity(body);
        Assertions.assertSame(body, matrix.get(positionEntity));
    }

    @Test
    void updateTest() {

        field.putEntity(liveMock);
        field.update();
        verify(liveMock).makeAMove();
        field.update();
        verify(liveMock, times(2)).makeAMove();
    }

    @Test
    void puttingRemovesExistingEntity() {
        body = new LifelessBotBody(positionEntity, new EnergyEntity(0));
        field.putEntity(liveMock);
        field.putEntity(body);
        field.update();
        Assertions.assertSame(matrix.get(positionEntity), body);
    }

    @Test
    void entitiesCount() {
        when(liveMock.position()).thenReturn(new PositionEntity(2, 1));
        field.putEntity(liveMock);
        field.putEntity(body);

        Assertions.assertSame(2, field.aliveEntitiesCount());

        field.update();

        Assertions.assertSame(1, field.aliveEntitiesCount());
    }
}