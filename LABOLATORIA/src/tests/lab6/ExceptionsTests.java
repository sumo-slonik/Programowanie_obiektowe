package lab6;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.GrassField;
import org.junit.Test;

import static org.junit.Assert.*;


public class ExceptionsTests {
    //testing exception in parser when we give incorrect input to parse
    @Test
    public void parserException()
    {
        String [] Smoves = new String[]{"f","incorrect input to parser","f","f","f","f","f","f","f","f"};
        try{
            MovieDirection[] moves = new OptionParser().parse(Smoves);
        } catch (IllegalArgumentException ex)
        {
            assertTrue(true);
            return;
        }
        fail();
    }
    //testing exception when we try to spawn two animals in the same position
    @Test
    public void collisionException()
    {
        IWorldMap map = new GrassField(10);
        try {
            Animal tmp1 = new Animal(map, new Vector2d(2, 2));
            Animal tmp2 = new Animal(map, new Vector2d(1, 2));
            map.place(tmp1);
            map.place(tmp2);
        }catch (IllegalArgumentException ex)
        {
            fail();
        }
        try
        {
            Animal tmp3 = new Animal(map, new Vector2d(1, 2));
            map.place(tmp3);
        } catch (IllegalArgumentException ex)
        {
            assertTrue(true);
            return;
        }
        fail();
    }
}
