package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;

public class Animal {
    //this vector describe position animal object in map 4x4
    private Vector2d position = new Vector2d(2, 2);
    // this parameter describe direction of animal
    private MapDirection orientation = MapDirection.NORTH;

    // here converting position to string in format "(x-position,y-position) DirectionOfOrientation"
    public String toString() {
        return position.toString() + " " + orientation.toString();
    }

    // method to change position in one  a move in a specific direction
    // and check
    public void movie(MovieDirection direction) {
        switch (direction) {
            // rotation is safe because we can't go over the edge in rotation process
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            // if we going forward or backward we have to check if we're not going over the edge
            // to do that we will use implemented before methods of vector class precedes and  follows
            // if movie make animal to going over the edge we ignore this movie
            case FORWARD:
                if (this.position.add(this.orientation.toUnitVector()).precedes(new Vector2d(4, 4)) &&
                        this.position.add(this.orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                    this.position = this.position.add(this.orientation.toUnitVector());
                }
                break;
            case BACKWARD:
                if (this.position.subtract(this.orientation.toUnitVector()).precedes(new Vector2d(4, 4)) &&
                        this.position.subtract(this.orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                }
        }

    }

}
