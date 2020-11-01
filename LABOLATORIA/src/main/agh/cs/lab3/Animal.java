package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
    //constructor
    private IWorldMap map;
    //this vector describe position animal object in map 4x4
    private Vector2d position;

    public Animal (IWorldMap map,Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
    }
    public Animal (IWorldMap map)
    {
        this.map = map;
        this.position = new Vector2d(2,2);
    }

    public Vector2d getPosition()
    {
        return this.position;
    }
    // this parameter describe direction of animal
    private MapDirection orientation = MapDirection.NORTH;

    // here converting position to string in format "(x-position,y-position) DirectionOfOrientation"
    public String toString() {
        return orientation.toString().substring(0,1);
    }

    public Boolean move(MovieDirection direction) {
        // rotation is safe because we can't go over the edge in rotation process
        // if we going forward or backward we have to check if we're not going over the edge
        // to do that we will use implemented before methods of vector class precedes and  follows
        // if movie make animal to going over the edge we ignore this movie
        switch (direction) {
            case RIGHT -> {
                this.orientation = this.orientation.next();
                return true;
            }
            case LEFT -> {
                this.orientation = this.orientation.previous();
                return true;
            }
            case FORWARD -> {
                if (map.canMoveTo(this.position.add(this.orientation.toUnitVector()))) {
                    this.position = this.position.add(this.orientation.toUnitVector());
                    return true;
                }
                return false;
            }
            case BACKWARD -> {
                if (map.canMoveTo(this.position.subtract(this.orientation.toUnitVector()))) {
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                    return true;
                }
                return false;
            }
        }
        return false;
    }

}
