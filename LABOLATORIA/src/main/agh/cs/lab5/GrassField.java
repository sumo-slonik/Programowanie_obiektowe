package agh.cs.lab5;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab5.Grass;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;


public class GrassField implements IWorldMap {
    private Vector2d maxPosition;
    private Vector2d minPosition;
    private ArrayList<Animal> animalsList;
    ArrayList<Grass> grassList = new ArrayList<Grass>(0);

    public GrassField(int howMany) {
        int maxPose = (int) Math.sqrt(howMany * 10);
        int howManyActual = 0;
        this.maxPosition = new Vector2d(0, 0);
        this.minPosition = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.animalsList = new ArrayList<Animal>(0);
        while (howManyActual < howMany) {
            int randomX = (int) (Math.random() * maxPose);
            int randomY = (int) (Math.random() * maxPose);
            if (placeGrass(new Grass(new Vector2d(randomX, randomY)))) {
                System.out.println(new Vector2d(randomX, randomY).toString()+" "+this.minPosition.toString()+" "+this.maxPosition.toString());
                howManyActual++;
            }
        }
    }


    public boolean placeGrass(Grass tmpGrass) {
        if (!isOccupied(tmpGrass.getPosition())) {
            grassList.add(tmpGrass);

            return true;
        }
        return false;
    }
    @Override
    public void addAnimal(Animal animal)
    {
        Vector2d animalPosition = animal.getPosition();
        int index = this.animalsList.size();
        animalsList.add(animal);
        animalMap[animalPosition.x][animalPosition.y] = index;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (animalPosition.follows(new Vector2d(0, 0)) && animalPosition.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))) {
            if (!isOccupied(animalPosition)) {
                int index = this.animalsList.size();
                animalsList.add(animal);
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
            actualiseMapRange(actualAnimal);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {

        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))) {
            for (Animal actual : animalsList) {
                if (actual.getPosition().equals(position)) {
                    return true;
                }
            }
            for (Grass actual : grassList) {
                if (actual.getPosition().equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))) {
            for (Animal actual : animalsList) {
                if (actual.getPosition().equals(position)) {
                    return actual;
                }
            }
            for (Grass actual : grassList) {
                if (actual.getPosition().equals(position)) {
                    return actual;
                }
            }
        }
        return null;
    }

    @Override
    public void actualiseMapRange(AbstractWorldMapElement mapElement)     {
        this.maxPosition = new Vector2d(Math.max(this.maxPosition.x,mapElement.getPosition().x),Math.max(this.maxPosition.y,mapElement.getPosition().y));
        this.minPosition = new Vector2d(Math.min(this.minPosition.x,mapElement.getPosition().x),Math.min(this.minPosition.y,mapElement.getPosition().y));
    }

    public ArrayList<Animal> returnAnimalList() {
        return this.animalsList;
    }

    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.minPosition, this.maxPosition);
    }
}
