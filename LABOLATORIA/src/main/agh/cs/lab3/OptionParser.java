package agh.cs.lab3;

import agh.cs.lab2.MovieDirection;
import java.util.Arrays;

public class OptionParser {
    public  MovieDirection [] parse(String [] toParse){
        MovieDirection [] result = new MovieDirection[toParse.length] ;
        int iter = 0;
        for (String i : toParse)
        {
            switch (i) {
                case "f", "forward" -> {
                    result[iter] = MovieDirection.FORWARD;
                    iter++;
                }
                case "r", "right" -> {
                    result[iter] = MovieDirection.RIGHT;
                    iter++;
                }
                case "l", "left" -> {
                    result[iter] = MovieDirection.LEFT;
                    iter++;
                }
                case "b", "backward" -> {
                    result[iter] = MovieDirection.BACKWARD;
                    iter++;
                }
                default -> {
                    throw new IllegalArgumentException(i + " is not legal move specification");
                }
            }
        }
        MovieDirection [] to_return = new MovieDirection[iter];
        if (iter >= 0) System.arraycopy(result, 0, to_return, 0, iter);
        return to_return;
    }
}
