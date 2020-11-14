package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //convert of the created vector class to the appropriate string format
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    // checks if the vector precedes the vector given as an argument
    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    // checks if the vector follows the vector given as an argument
    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    // turns the upper right corner of the rectangle described on vectors
    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    // returns the lower left corner of the rectangle described on vectors
    public Vector2d lowerRight(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    // returns the result of adding vectors
    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    // returns the result of vector subtraction
    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    //Check if the vectors are equal
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    ////returns the opposite vector
    public Vector2d opposite() {
        return new Vector2d(this.x * (-1), this.y * (-1));
    }
    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}
