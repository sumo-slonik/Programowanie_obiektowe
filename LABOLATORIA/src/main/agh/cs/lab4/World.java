package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab2.MovieDirection;

public class World {
    public static void main(String [] args)
    {
        MovieDirection[] directions =  OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        System.out.println(map.place(new Animal(map)));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

    }
}
