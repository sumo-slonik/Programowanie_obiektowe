package test;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static main.MapDirection.*;
public class MapDirectionTest {
    @Test
    public void next_test()
    {
        assertEquals(NORTH.next(),EAST);
        assertEquals(WEST.next(),NORTH);
        assertEquals(EAST.next(),SOUTH);
        assertEquals(SOUTH.next(),WEST);

    }
    @Test
    public void prev_test()
    {
        assertEquals(NORTH.previous(),WEST);
        assertEquals(WEST.previous(),SOUTH);
        assertEquals(EAST.previous(),NORTH);
        assertEquals(SOUTH.previous(),EAST);

    }

}
