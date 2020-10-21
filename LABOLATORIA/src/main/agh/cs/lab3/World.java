package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab3.OptionParser.*;

public class World {
    public static void main(String [] args)
    {
//        Animal zwierze =new Animal();
//        zwierze.movie(MovieDirection.RIGHT);
//        zwierze.movie(MovieDirection.FORWARD);
//        zwierze.movie(MovieDirection.FORWARD);
//        zwierze.movie(MovieDirection.FORWARD);
//        System.out.println(zwierze.toString());
        String test = "rfff";
        MovieDirection [] argument =  OptionParser.parse(test);
        for(MovieDirection i : argument)
        {
            System.out.println(i);
        }

    }
}
