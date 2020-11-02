package lab4;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;

import org.junit.Test;

import static org.junit.Assert.*;


public class RectangularMapTests {
    @Test
    public void spawnTest()
    {
        IWorldMap map = new RectangularMap(10, 5);
        // testing one parameter and two parameters constructor
        Animal tmp = new Animal(map);
        Animal tmp1 = new Animal(map, new Vector2d(1,4));
        map.place(tmp);
        map.place(tmp1);
        assertEquals(map.objectAt(tmp.getPosition()),tmp);
        assertEquals(map.objectAt(tmp1.getPosition()),tmp1);
        assertNotSame(map.objectAt(tmp1.getPosition()), map.objectAt(tmp.getPosition()));
    }
    @Test
    public void oneAnimalRunTest()
    {
        RectangularMap map = new RectangularMap(5, 10);
        Animal tmp1 = new Animal(map, new Vector2d(0,0));
        map.place(tmp1);
        // simple movement
        String [] Smoves = new String[]{"f","f","f","f","f","f","f","f","f","f"};
        MovieDirection [] moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(0,9)),tmp1);
        // check going out of the range
        Smoves = new String[]{"f","f"};
        moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(0,9)),tmp1);
        //move right and check out of range
        Smoves = new String[]{"r","f","f","f","f"};
        moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(4,9)),tmp1);
        //move down and check out of range
        Smoves = new String[]{"r","f","f","f","f","f","f","f","f","f"};
        moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(4,0)),tmp1);
    }
    @Test
    public void twoAnimalMovementTest()
    {
        IWorldMap map = new RectangularMap(10, 5);
        Animal tmp = new Animal(map, new Vector2d(0,0));
        Animal tmp1 = new Animal(map, new Vector2d(3,0));
        map.place(tmp);
        map.place(tmp1);
        String [] Smoves = new String[]{"f","f","f","f","f","f"};
        MovieDirection [] moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(0,3)),tmp);
        assertEquals(map.objectAt(new Vector2d(3,3)),tmp1);

    }
    @Test
    public void animalCollisionTest()
    {
        IWorldMap map = new RectangularMap(10, 5);
        Animal tmp = new Animal(map, new Vector2d(4,4));
        Animal tmp1 = new Animal(map, new Vector2d(1,4));
        map.place(tmp);
        map.place(tmp1);
        // first collision
        String [] Smoves = new String[]{"l","r","f","f","f","f"};
        MovieDirection [] moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(2,4)),tmp1);
        assertEquals(map.objectAt(new Vector2d(3,4)),tmp);
        //second collision
        Smoves = new String[]{"b","b","b","b","f","f","f","f","f","f"};
        moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(2,4)),tmp1);
        assertEquals(map.objectAt(new Vector2d(3,4)),tmp);
    }

}
