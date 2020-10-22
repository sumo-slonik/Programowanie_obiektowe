package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;
    public String toString() {
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
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                }
    }

    }

}
