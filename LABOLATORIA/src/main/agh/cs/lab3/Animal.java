package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
    //this vector describe position animal object in map 4x4
    private Vector2d position = new Vector2d(2, 2);
    // this parameter describe direction of animal
    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    // here converting position to string in format "N-North S-South E-East W-West
    public String toString() {
        return orientation.toString().substring(0,1);
    }
    //constructor of animal class
    public Animal (IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
    }
    //constructor on default position
    public Animal (IWorldMap map)
    {
        this.map = map;
    }
    // no argument constructor is not necessary anymore
    // method to change position in move in a specific direction
    // and check
    public Boolean move(MovieDirection direction) {
        // rotation is safe because we can't go over the edge in rotation process
        // if we going forward or backward we have to check if we're not going over the edge
        // to do that we will use implemented before methods of vector class precedes and  follows
        // if movie make animal to going over the edge we ignore this movie
        //returns true if move is done and false otherwise
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
    // this method return current position of animal
    public Vector2d getPosition(){
        return  this.position;
    }
}
