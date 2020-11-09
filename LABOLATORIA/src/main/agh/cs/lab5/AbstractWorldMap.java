package agh.cs.lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import java.util.ArrayList;

public class AbstractWorldMap implements IWorldMap {

    protected Vector2d maxPosition;
    protected Vector2d minPosition;
    protected int[][] animalMap;
    protected ArrayList<Animal> animalsList;


    public void addAnimal(Animal animal)
    {
        Vector2d animalPosition = animal.getPosition();
        int index = this.animalsList.size();
        animalsList.add(animal);
        animalMap[animalPosition.x][animalPosition.y] = index;
    }
    public void optional2dAfterRunActualise(Vector2d prevPose,Vector2d actualPose,int i,int size)
    {
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        actualiseMapRange(animal);
        if (animalPosition.follows(this.minPosition) && animalPosition.precedes(this.maxPosition))
        {
            if (!isOccupied(animalPosition))
            {
                addAnimal(animal);
                actualiseMapRange(animal);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(MovieDirection[] directions) {
        int size = animalsList.size();
        for (int i = 0; i < directions.length; i++) {
            Animal actualAnimal = animalsList.get(i % size);
            Vector2d positionBefore = new Vector2d(actualAnimal.getPosition().x, actualAnimal.getPosition().y);
            actualAnimal.move(directions[i]);
            animalsList.remove(i % size);
            animalsList.add(i % size, actualAnimal);
            Vector2d animalPosition = actualAnimal.getPosition();
            optional2dAfterRunActualise(positionBefore,animalPosition,i,size);
            actualiseMapRange(actualAnimal);
        }

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

    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.minPosition, this.maxPosition);
    }
}
