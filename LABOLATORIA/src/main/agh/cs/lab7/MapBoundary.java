package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

// this class is using to get min and max pose in map
public class MapBoundary implements IPositionChangeObserver{
    Comparator<Vector2d> yComparator = new YComparator();
    Comparator<Vector2d> xComparator = new XComparator();
    public SortedSet<Vector2d> ySorted = new TreeSet<Vector2d>(yComparator);
    public SortedSet<Vector2d> xSorted= new TreeSet<Vector2d>(xComparator);
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!oldPosition.equals(newPosition))
        {
            this.delete(oldPosition);
            this.add(newPosition);
        }
    }
    public void add(Vector2d position)
    {
        this.ySorted.add(position);
        this.xSorted.add(position);
    }
    public void delete (Vector2d position)
    {
        this.ySorted.remove(position);
        this.xSorted.remove(position);
    }
    public String toString()
    {
        return "x: "+ this.xSorted.toString() +"\n"+"y: "+this.ySorted.toString();
    }
    public Vector2d getLeftCorner(){
        return new Vector2d(this.xSorted.last().x,this.ySorted.last().y);
    }
    public Vector2d getRightCorner(){
        return new Vector2d(this.xSorted.first().x,this.ySorted.first().y);
    }
}
