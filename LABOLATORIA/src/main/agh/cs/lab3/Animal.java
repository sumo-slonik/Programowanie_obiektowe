package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
<<<<<<< HEAD
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
=======
    private Vector2d position = new Vector2d(2, 2);
>>>>>>> parent of 44084a4... completing lab 3
    private MapDirection orientation = MapDirection.NORTH;
    public String toString() {
<<<<<<< HEAD
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
=======
        return position.toString() + " "+ orientation.toString();
    }
    public void movie(MovieDirection direction)
    {
        switch (direction){
            case RIGHT :
                this.orientation =this.orientation.next();
                break;
            case LEFT :
                this.orientation =this.orientation.previous();
                break;
            case FORWARD :
                if (this.position.add(this.orientation.toUnitVector()).precedes(new Vector2d(4,4)) &&
                        this.position.add(this.orientation.toUnitVector()).follows(new Vector2d(0,0)))
            {
                this.position = this.position.add(this.orientation.toUnitVector());
            }
                break;
            case BACKWARD:
                if (this.position.subtract(this.orientation.toUnitVector()).precedes(new Vector2d(4,4)) &&
                        this.position.subtract(this.orientation.toUnitVector()).follows(new Vector2d(0,0)))
                {
>>>>>>> parent of 44084a4... completing lab 3
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                    return true;
                }
<<<<<<< HEAD
                return false;
            }
        }
        return false;
=======
    }

>>>>>>> parent of 44084a4... completing lab 3
    }

}
