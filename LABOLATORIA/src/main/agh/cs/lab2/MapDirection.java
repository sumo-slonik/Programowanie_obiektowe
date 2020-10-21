package agh.cs.lab2;
import agh.cs.lab2.MovieDirection;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    //convert vector to string
    public String toString(){
        return switch (this) {
            case EAST -> "Wschód";
            case WEST -> "Zachód";
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
        };
    }
    public MovieDirection toMovieDirection()
    {
        return switch(this) {
            case EAST -> MovieDirection.RIGHT;
            case WEST -> MovieDirection.LEFT;
            case NORTH -> MovieDirection.FORWARD;
            case SOUTH -> MovieDirection.BACKWARD;
        };
    }
    //returns the next direction clockwise
    public MapDirection next(){
        return switch(this){
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case NORTH -> EAST;
        };
    }
    //returns the next direction counterclockwise
    public MapDirection previous(){
        return switch(this){
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case NORTH -> WEST;
        };
    }
    //returns a unit vector in the specified direction
    public Vector2d toUnitVector(){
        return switch(this){
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case NORTH -> new Vector2d(0,1);
        };
    }
}
