package agh.cs.lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;

public class World {
    public static void main (String [] args)
    {
        MovieDirection[] directions = new OptionParser().parse(args);
        GrassField map = new GrassField(10);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        System.out.print(map.toString());
    }
}
