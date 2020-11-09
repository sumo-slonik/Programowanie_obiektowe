package agh.cs.lab5;
import agh.cs.lab2.Vector2d;

//grass is map element like animal but grass can't move
// and have lover priority in display

public class Grass implements IWorldMapElement{

    private final Vector2d position;
    public Grass(Vector2d position)
    {
        this.position = position;
    }
    @Override
    public Vector2d getPosition()
    {
        return this.position;
    }
    public String toString()
    {
        return "*";
    }
}
