package main;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection ortientation = MapDirection.NORTH;
    public String toString() {
        return position.toString() + " "+ ortientation.toString();
    }
    public void movie(MovieDirection direction)
    {
        switch (direction){
            case RIGHT :
                this.ortientation=this.ortientation.next();
                break;
            case LEFT :
                this.ortientation=this.ortientation.previous();
                break;
            case FORWARD :
                if (this.position.add(this.ortientation.toUnitVector()).precedes(new Vector2d(4,4)) &&
                        this.position.add(this.ortientation.toUnitVector()).follows(new Vector2d(0,0)))
            {
                this.position = this.position.add(this.ortientation.toUnitVector());
            }
                break;
            case BACKWARD:
                if (this.position.subtract(this.ortientation.toUnitVector()).precedes(new Vector2d(4,4)) &&
                        this.position.subtract(this.ortientation.toUnitVector()).follows(new Vector2d(0,0)))
                {
                    this.position = this.position.subtract(this.ortientation.toUnitVector());
                }
    }

    }

}
