package Vector;

import org.junit.Test;

import static org.junit.Assert.*;


public class VectorTest {
    @Test
    public void sum() {
        assertEquals(new Vector(5, 10, 9), new Vector(1, 2, 3).sum(new Vector(4, 8, 6)));
        assertEquals(new Vector(-2, -1), new Vector(1, -2).sum(new Vector(-3, 1)));
        assertEquals(new Vector(), new Vector().sum(new Vector()));
        try {
            new Vector(4, 5).sum(new Vector(6, 7, 8));
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void difference() {
        assertEquals(new Vector(-3, -6, -3), new Vector(1, 2, 3).difference(new Vector(4, 8, 6)));
        assertEquals(new Vector(4, -3), new Vector(1, -2).difference(new Vector(-3, 1)));
    }

    @Test
    public void multiplication() {
        assertEquals(new Vector(5, 10, 15), new Vector(1, 2, 3).multiplication(5));
        assertEquals(new Vector(8, -16), new Vector(1, -2).multiplication(8));
    }

    @Test
    public void division() {
        assertEquals(new Vector(0.5, 1, 1.5), new Vector(1, 2, 3).division(2));
        assertEquals(new Vector(0.2, -0.4), new Vector(1, -2).division(5));
    }

    @Test
    public void module() {
        assertEquals(3, new Vector(1, -2, 2).module(), 1e-5);
        assertEquals(5, new Vector(3, 4).module(), 1e-5);
    }

    @Test
    public void scalarProduct() {
        assertEquals(41, new Vector(-6, 9, 5).scalarProduct(new Vector(-1, 0, 7)), 1e-5);
        assertEquals(6, new Vector(5, -4).scalarProduct(new Vector(2, 1)), 1e-5);
    }

    @Test
    public void vectorProduct() {
        assertEquals(new Vector(18, 12, 6), Vector.vectorProduct(new Vector(-2, 3, 0), new Vector(-2, 0, 6)));
        assertEquals(new Vector(18, 12, 6), Vector.vectorProduct(new Vector(-2, 3, 0), new Vector(-2, 0, 6)));
    }

}