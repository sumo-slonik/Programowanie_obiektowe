package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab7.MapBoundary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {

    private ArrayList<Grass> grassList = new ArrayList<Grass>(0);
    //initialise GrassField
    public GrassField(int howMany) {
        // calculate max position of grass spawn
        int maxPose = (int) Math.sqrt(howMany * 10);
        int howManyActual = 0;
        // this is actual range of map, it will be actualise by actualiseMapRange
        // every time we put new element on map and in every move of animal
        this.animals  = new LinkedHashMap<>();
        this.boundary = new MapBoundary();
        // procedure of start grass spawning
        while (howManyActual < howMany) {
            int randomX = (int) (Math.random() * maxPose);
            int randomY = (int) (Math.random() * maxPose);
            if (placeGrass(new Grass(new Vector2d(randomX, randomY)))) {
                howManyActual++;
            }
        }
    }
    // method works like place but for grass
    public boolean placeGrass(Grass tmpGrass) {
        if (!isOccupied(tmpGrass.getPosition())) {
            grassList.add(tmpGrass);
            this.boundary.add(tmpGrass.getPosition());
            return true;
        }
        return false;
    }
    //adds animal to animal list
    @Override
    public void addAnimal(Animal animal)
    {
        animals.put(animal.getPosition(),animal);
        this.boundary.add(animal.getPosition());
    }
    // checking possibility od movement to specific place
    // map have dynamic range so we only have to check new position have plus co-ordinates
    // and we have to check if there is an animal in specific position
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)) && !isOccupiedByAnimal(position);
    }
    // we have to spell through the list of animals and
    // grasses and check if the field we have selected is not already occupied
    @Override
    public boolean isOccupied(Vector2d position) {

        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))) {
            if (isOccupiedByAnimal(position)) {
                return true;
            }
            else {
                for (Grass actual : grassList) {
                    if (actual.getPosition().equals(position)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // returns object (grass or animal) on specific position
    @Override
    public Object objectAt(Vector2d position) {
        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))) {
            if (animals.getOrDefault(position, null) != null)
            {
                return animals.get(position);
            }
            for (Grass actual : grassList) {
                if (actual.getPosition().equals(position)) {
                    return actual;
                }
            }
        }
        return null;
    }
    public ArrayList<Animal> returnAnimalList() {
        return this.animalsList;
    }
    public ArrayList<Grass> returnGrassList() {
        return this.grassList;
    }
    //method like isOccupiedBy but checking only animals
}
