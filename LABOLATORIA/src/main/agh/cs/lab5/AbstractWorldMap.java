package agh.cs.lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;

import java.util.ArrayList;

public class AbstractWorldMap implements IWorldMap {

    private Vector2d maxPosition;
    private Vector2d minPosition;
    private int[][] animalMap;
    private ArrayList<Animal> animalsList;

    public void addAnimal(Animal animal)
    {
        Vector2d animalPosition = animal.getPosition();
        int index = this.animalsList.size();
        animalsList.add(animal);
        animalMap[animalPosition.x][animalPosition.y] = index;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (animalPosition.follows(this.minPosition) && animalPosition.precedes(this.maxPosition))
        {
            if (!isOccupied(animalPosition))
            {
                addAnimal(animal);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(MovieDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }

    @Override
    public void actualiseMapRange(AbstractWorldMapElement mapElement) {

    }
}
