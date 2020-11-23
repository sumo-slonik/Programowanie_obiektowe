package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.Comparator;

public class XComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2)
    {
        if (o1.x > o2.x)
            return -1;
        else if (o1.x < o2.x)
            return 1;
        else{
            if (o1.y > o2.y)
                return -1;
            else if (o1.y < o2.y)
                return 1;
        }
        return 0;
    }
}
