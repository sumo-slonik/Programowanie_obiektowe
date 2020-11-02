package agh.cs.lab4;

import agh.cs.lab2.MovieDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.MapVisualizer;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap {

    private final int width;
    private final int height;
    private ArrayList<Animal> animalsList;
    private int[][] animalMap;

    public RectangularMap(int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
        this.animalsList = new ArrayList<Animal>(0);
        this.animalMap = new int [width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height;y++)
            {
                this.animalMap[x][y] = -1;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(width-1, height-1)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (animalPosition.follows(new Vector2d(0, 0)) && animalPosition.precedes(new Vector2d(width, height)))
        {
            if (!isOccupied(animalPosition))
            {
                int index = this.animalsList.size();
                animalsList.add(animal);
                animalMap[animalPosition.x][animalPosition.y] = index;
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(MovieDirection[] directions) {
        int size = animalsList.size();
        for (int i =0;i < directions.length;i++)
        {
            Animal actualAnimal = animalsList.get(i%size);
            Vector2d positionBefore = new Vector2d(actualAnimal.getPosition().x,actualAnimal.getPosition().y);
            actualAnimal.move(directions[i]);
            if (!positionBefore.equals(actualAnimal.getPosition()))
            {
                this.animalMap[positionBefore.x][positionBefore.y] = -1;
                this.animalMap[actualAnimal.getPosition().x][actualAnimal.getPosition().y] = i%size;
            }
            animalsList.remove(i%size);
            animalsList.add(i%size,actualAnimal);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(this.width-1,this.height-1)))
        {
            return this.animalMap[position.x][position.y] != -1;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (isOccupied(position))
        {
            return this.animalsList.get(this.animalMap[position.x][position.y]);
        }
        return null;
    }
    public ArrayList<Animal> returnAnimalList()
    {
        return this.animalsList;
    }
    public String toString()
    {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(new Vector2d(0,0),new Vector2d(this.width-1,this.height-1));
    }
}
