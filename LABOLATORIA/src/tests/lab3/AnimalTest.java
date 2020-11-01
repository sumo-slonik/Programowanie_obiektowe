package lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab3.OptionParser;
import org.junit.Test;
import agh.cs.lab3.Animal;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    // checking the spawn position of animal
    @Test
    public void start_position_test() {
        Animal tested = new Animal();
        assertEquals(tested.toString(), "(2,2) Północ");
    }

    // Testing of animal rotation in 360 degrees  first to the right than to the left
    @Test
    public void orientation_test() {
        Animal tested = new Animal();
        String test = "rrrr";
        MapDirection orient = MapDirection.NORTH;
        MovieDirection[] argument = OptionParser.parse(test);
        for (int i = 0; i < 4; i++) {
            tested.movie(argument[i]);
            orient = orient.next();
            assertEquals(tested.toString(), "(2,2)" + " " + orient.toString());
        }
        test = "llll";
        argument = OptionParser.parse(test);
        for (int i = 0; i < 4; i++) {
            tested.movie(argument[i]);
            orient = orient.previous();
            assertEquals(tested.toString(), "(2,2)" + " " + orient.toString());
        }
    }

    // testing the passage of the whole map to the circle with an attempt to go behind each wall of the board
    @Test
    public void position_test() {
        Animal tested = new Animal();
        //correct positions for all movies
        String[] results = {"(2,3) Północ", "(2,4) Północ", "(2,4) Północ", "(2,4) Zachód", "(1,4) Zachód", "(0,4) Zachód", "(0,4) Zachód"
                , "(0,4) Południe", "(0,3) Południe", "(0,2) Południe", "(0,1) Południe", "(0,0) Południe", "(0,0) Południe", "(0,0) Wschód", "(1,0) Wschód", "(2,0) Wschód"
                , "(3,0) Wschód", "(4,0) Wschód", "(4,0) Wschód", "(4,0) Północ", "(4,1) Północ", "(4,2) Północ", "(4,3) Północ", "(4,4) Północ", "(4,4) Północ"};
        //input movies as string to test parsing function output in input of animal
        String test = "ffflffflffffflffffflfffff";
        assertEquals(results.length, test.length());
        MovieDirection[] movies = OptionParser.parse(test);
        for (int i = 0; i < results.length; i++) {
            tested.movie(movies[i]);
            assertEquals(tested.toString(), results[i]);
        }


    }

}
