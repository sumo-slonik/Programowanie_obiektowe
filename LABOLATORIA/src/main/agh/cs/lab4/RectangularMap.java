package agh.cs.lab4;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.Arrays;

public class RectangularMap implements IWorldMap {


    private final int width;
    private final int height;
    private int[][] animalMap;
    private ArrayList<Animal> animalsList;

    public RectangularMap(int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
        this.animalsList = new ArrayList<Animal>(0);

        // if place is not occupied value of this array is equal to -1 in this place
        this.animalMap = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.animalMap[i][j] = -1;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d start = new Vector2d(0, 0);
        Vector2d end = new Vector2d(width, height);
        return position.follows(start) && position.precedes(end) && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getPosition())) {
            this.animalsList.add(animal);
            this.animalMap[animal.getPosition().x][animal.getPosition().y] = animalsList.size() - 1;
            return true;
        }
        return false;
    }

    @Override
    public void run(MovieDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            Animal actualAnimal = this.animalsList.get(i % this.animalsList.size());
            Vector2d prevPosition = actualAnimal.getPosition();
            if (actualAnimal.move(directions[i])) {
                this.animalMap[prevPosition.x][prevPosition.y] = -1;
                this.animalMap[actualAnimal.getPosition().x][actualAnimal.getPosition().y] = i % this.animalsList.size();
            }
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animalMap[position.x][position.y] != -1;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (isOccupied(position)) {
            return this.animalsList.get(this.animalMap[position.x][position.y]);
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer frame = new MapVisualizer(this);
        return frame.draw(new Vector2d(0, 0), new Vector2d(this.width - 1, this.height - 1));
    }
}
