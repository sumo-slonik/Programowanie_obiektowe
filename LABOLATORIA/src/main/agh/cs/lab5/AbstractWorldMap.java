package agh.cs.lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;
import agh.cs.lab7.MapBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

// this class include common elements of GrassField and RectangularMap

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected int[][] animalMap;
    protected MapBoundary boundary = null;
    protected ArrayList<Animal> animalsList;
    protected Map<Vector2d, Animal> animals;

    //this is supporting method of place, if map don't have 2d array can by override by empty function
    public void addAnimal(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        int index = this.animalsList.size();
        animals.put(animal.getPosition(), animal);
        animalMap[animalPosition.x][animalPosition.y] = index;
    }

    // this if supporting method to place
    // this method actualise 2d animal array,and have to override in specific class
    public void optional2dAfterRunActualise(Vector2d prevPose, Vector2d actualPose, int i, int size) {
    }

    // boolean function checking possibility of move class-specific
    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    //this function spawn animal on map
    //don't need to be override
    //returns true if spawning succeeded and false if not
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        actualiseMapRange(animal);
        if (!isOccupiedByAnimal(animalPosition)) {
            addAnimal(animal);
            actualiseMapRange(animal);
            animal.addObserver(this);
            animal.addObserver(this.boundary);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " Is actual occupied and you try to put animal here");
    }

    //this function make animals run in moves contained in array directions
    //don't need to be override
    @Override
    public void run(MovieDirection[] directions) {
        ArrayList<Animal> IterationCopy = new ArrayList<>(this.animals.values());
        int size = IterationCopy.size();
        for (int i = 0; i < directions.length; i++) {
            Animal actualAnimal = IterationCopy.get(i % size);
            Vector2d positionBefore = new Vector2d(actualAnimal.getPosition().x, actualAnimal.getPosition().y);
            actualAnimal.move(directions[i]);
            IterationCopy.remove(i % size);
            IterationCopy.add(i % size, actualAnimal);
            Vector2d animalPosition = actualAnimal.getPosition();
            actualAnimal.positionChanged(positionBefore, animalPosition);
            optional2dAfterRunActualise(positionBefore, animalPosition, i, size);
            actualiseMapRange(actualAnimal);
        }
    }

    //this method returns occupied of specific place and this
    //method have to be override
    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    //this returns object of specific place
    //method have to be override
    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
    // this if supporting method to run and place
    // this method actualise map range if map range is dynamic,but have be to override to work

    @Override
    public void actualiseMapRange(IWorldMapElement mapElement) {

    }

    //this method converting map to sting using mapVisualiser
    //don't need to be override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.boundary.getLeftCorner(), this.boundary.getRightCorner());
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.getOrDefault(position, null) != null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal actual = this.animals.getOrDefault(oldPosition, null);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, actual);
    }

}
