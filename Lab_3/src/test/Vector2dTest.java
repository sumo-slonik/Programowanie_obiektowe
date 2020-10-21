package test;

import main.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Vector2dTest {
    @Test
    public void equals_test() {
        Vector2d vector_1 = new Vector2d(1,1);
        Vector2d vector_2 = new Vector2d(1,1);
        assertEquals(vector_2, vector_1);
    }
    @Test
    public void str_test(){
        Vector2d vector_1 = new Vector2d(1,1);
        assertEquals(vector_1.toString(),"(1,1)");
    }
    @Test
    public void precedes_tes()
    {
        Vector2d vector_1 = new Vector2d(1,1);
        Vector2d vector_2 = new Vector2d(2,2);
        assertTrue(vector_1.precedes(vector_2));
        assertFalse(vector_2.precedes(vector_1));
    }
    @Test
    public void follows_test(){
        Vector2d vector_1 = new Vector2d(1,1);
        Vector2d vector_2 = new Vector2d(2,2);
        assertFalse(vector_1.follows(vector_2));
        assertTrue(vector_2.follows(vector_1));
    }
    @Test
    public void upper_r_test(){
        Vector2d vector_1 = new Vector2d(3,1);
        Vector2d vector_2 = new Vector2d(2,3);
        Vector2d vector_3 = new Vector2d(3,3);
        assertEquals(vector_1.upperRight(vector_2),vector_3);
    }
    @Test
    public void lower_l_test(){
        Vector2d vector_1 = new Vector2d(3,1);
        Vector2d vector_2 = new Vector2d(2,3);
        Vector2d vector_3 = new Vector2d(2,1);
        assertEquals(vector_1.lowerRight(vector_2),vector_3);
    }
    @Test
    public void add_test(){
        Vector2d vector_1 = new Vector2d(3,1);
        Vector2d vector_2 = new Vector2d(2,3);
        Vector2d vector_3 = new Vector2d(5,4);
        assertEquals(vector_1.add(vector_2),vector_3);
    }
    @Test
    public void sub_test(){
        Vector2d vector_1 = new Vector2d(3,1);
        Vector2d vector_2 = new Vector2d(2,3);
        Vector2d vector_3 = new Vector2d(1,-2);
        assertEquals(vector_1.subtract(vector_2),vector_3);
    }
    @Test
    public void opposite_test(){
        Vector2d vector_1 = new Vector2d(3,1);
        Vector2d vector_2 = new Vector2d(-3,-1);
        assertEquals(vector_1.opposite(),vector_2);
    }

    
}
