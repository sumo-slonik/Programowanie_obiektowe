package lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab5.Grass;
import agh.cs.lab5.GrassField;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class GrassFieldTests {
    //testing number of spawn grass

    @Test
    public void grassSpawn()
    {
        GrassField map = new GrassField(10);
        ArrayList <Grass> list = map.returnGrassList();
        assertEquals(list.size(),10);
    }
    //testing one animal movement and collisions with grass
    @Test
    public void oneAnimalRunTest()
    {
        GrassField map = new GrassField( 10);
        Animal tmp1 = new Animal(map, new Vector2d(0,0));
        map.place(tmp1);
        // simple movement
        String [] Smoves = new String[]{"f","f","f","f","f","f","f","f","f","f"};
        MovieDirection[] moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(0,10)),tmp1);
        // collision with grass
        Grass tmp = new Grass(new Vector2d(0,11));
        map.placeGrass(tmp);
        Smoves = new String[]{"f"};
        moves = new OptionParser().parse(Smoves);
        map.run(moves);
        assertEquals(map.objectAt(new Vector2d(0,11)),tmp1);
    }
    @Test
    public void animalCollisionTest()
    {
        // not work now because we use exceptions,
        // exceptions tests is in lab6 test
    }

}
