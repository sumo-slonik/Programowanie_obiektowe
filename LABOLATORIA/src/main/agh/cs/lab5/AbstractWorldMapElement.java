package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

/*
After a thought, it does not need an abstract class because the getPosition()
 method has to be overwritten in a particular type of map element anyway.
 That's why the IWorldMapElement interface turned out to be a great
 help in implementation.
 */
public class AbstractWorldMapElement {
    private Vector2d position;
    public Vector2d getPosition()
    {
        return this.position;
    }
}
