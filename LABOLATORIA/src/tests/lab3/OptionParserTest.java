package lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab3.OptionParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// testing paring function using conversation of mapDirection to movieDirection
public class OptionParserTest {
    @Test
    public void parse_test() {
        //here we creating default vector
        MapDirection direction = MapDirection.NORTH;
        //input test to parse
        String to_test = "frblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrblfrbl";
        //converting string to movieDirection type
        MovieDirection[] result = OptionParser.parse(to_test);
        for (MovieDirection i : result) {
            //here we testing equality of Converted string and properly rotated default vector
            assertEquals(i, direction.toMovieDirection());
            // here we rotate vector in clockwise
            direction = direction.next();
        }

    }
}
