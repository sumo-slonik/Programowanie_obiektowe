package agh.cs.lab4;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab5.AbstractWorldMap;
import agh.cs.lab5.AbstractWorldMapElement;
import agh.cs.lab5.IWorldMapElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d maxPosition;
    private final Vector2d minPosition;

    public RectangularMap(int width, int height) {
        this.maxPosition = new Vector2d(Math.max(width - 1, 0), Math.max(height - 1, 0));
        this.minPosition = new Vector2d(0, 0);
        this.animals  = new LinkedHashMap<>();
        this.animalMap = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.animalMap[x][y] = -1;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.minPosition) && position.precedes(this.maxPosition) && !isOccupied(position);
    }

    @Override
    public void optional2dAfterRunActualise(Vector2d prevPose, Vector2d actualPose, int i, int size) {
        if (!prevPose.equals(actualPose)) {
            this.animalMap[prevPose.x][prevPose.y] = -1;
            this.animalMap[actualPose.x][actualPose.y] = i % size;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.getOrDefault(position, null) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }

    @Override
    public void actualiseMapRange(IWorldMapElement mapElement) {
        //pass
    }

    public ArrayList<Animal> returnAnimalList() {
        return this.animalsList;
    }
}
