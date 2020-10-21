package lab2;
import agh.cs.lab2.MapDirection;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MapDirectionTest {
    @Test
    public void next_test()
    {
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);

    }
    @Test
    public void prev_test()
    {
        assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST);
        assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH);
        assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST);

    }

}
