package agh.cs.lab3;

import agh.cs.lab2.MovieDirection;

public class World {
    public static void main(String [] args)
    {
        Animal zwierze =new Animal();
        zwierze.movie(MovieDirection.RIGHT);
        zwierze.movie(MovieDirection.FORWARD);
        zwierze.movie(MovieDirection.FORWARD);
        zwierze.movie(MovieDirection.FORWARD);
        System.out.println(zwierze.toString());
    }
}
