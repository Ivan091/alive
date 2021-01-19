package com.model.simulation.field;

import com.model.simulation.entities.Entity;
import com.model.simulation.entities.alive.Alive;
import com.model.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.model.simulation.entities.alive.qualities.position.Position;
import com.model.simulation.entities.alive.qualities.position.PositionEntity;
import com.model.simulation.entities.lifeless.LifelessBotBody;
import com.model.simulation.field.matrix.MatrixEntities;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class FieldLiveTest {

    private final Field field = new FieldLive(13, 11);
    private final MatrixEntities matrix = field.getCellsMatrix();
    private Position positionEntity = new PositionEntity(1, 1);
    ;
    private Alive liveMock = mock(Alive.class);
    private Entity body = new LifelessBotBody(positionEntity, new EnergyEntity(0));

    @BeforeEach
    void setBotMock() {
        when(liveMock.isAlive()).thenReturn(true);
        when(liveMock.getPosition()).thenReturn(positionEntity);
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(13, field.getWidth());
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(11, field.getHeight());
    }

    @Test
    void getCellsMatrix() {
        Assertions.assertNotNull(matrix);
        Assertions.assertEquals(field.getWidth(), matrix.getWidth());
        Assertions.assertEquals(field.getHeight(), matrix.getHeight());
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
        when(liveMock.getPosition()).thenReturn(new PositionEntity(2, 1));
        field.putEntity(liveMock);
        field.putEntity(body);

        Assertions.assertSame(2, field.aliveEntitiesCount());

        field.update();

        Assertions.assertSame(1, field.aliveEntitiesCount());
    }
}