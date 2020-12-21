package alive.field;

import alive.entities.Entity;
import alive.entities.alive.Alive;
import alive.entities.lifeless.LifelessBotBody;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.Position;
import alive.entities.qualities.position.PositionEntity;
import alive.field.cells.CellMatrix;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class FieldLiveTest {

    private final Field field = new FieldLive(13, 11);
    private final CellMatrix matrix = field.getCellsMatrix();
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
        Assertions.assertSame(body, matrix.getEntity(positionEntity));
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
        verify(liveMock).finalizeBeforeErasingFromField();
        Assertions.assertSame(matrix.getEntity(positionEntity), body);
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