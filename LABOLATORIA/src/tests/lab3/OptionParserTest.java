package lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab3.OptionParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OptionParserTest {
    @Test
    public void parse_test()
    {
        MapDirection direction = MapDirection.NORTH;
        String to_test = "frblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrbl";
        MovieDirection [] result = OptionParser.parse(to_test);
        for (MovieDirection i : result)
        {
            assertEquals(i,direction.toMovieDirection());
            direction = direction.next();
        }

    }
}
