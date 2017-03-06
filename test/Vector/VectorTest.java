package Vector;

import org.junit.Test;

import static org.junit.Assert.*;


public class VectorTest {

    private final Vector vectorA = new Vector(1, 2, 3);
    private final Vector vectorB = new Vector(4, 8, 6);
    private final Vector vectorC = new Vector(1, -2);
    private final Vector vectorD = new Vector(-3, 1);
    private final Vector vectorE = new Vector(4, 5);
    private final Vector vectorF = new Vector(6, 7, 8);

    @Test
    public void sum() throws Exception {
        vectorA.sum(vectorB);
        assertEquals(new Vector(5, 10, 9), vectorA);
        vectorC.sum(vectorD);
        assertEquals(new Vector(-2, -1), vectorC);

        try {
            vectorE.sum(vectorF);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void difference() {
        vectorA.difference(vectorB);
        assertEquals(new Vector(-3, -6, -3), vectorA);
        vectorC.difference(vectorD);
        assertEquals(new Vector(4, -3), vectorC);
    }

    @Test
    public void multiplication() {
        vectorA.multiplication(5);
        assertEquals(new Vector(5, 10, 15), vectorA);
        vectorC.multiplication(8);
        assertEquals(new Vector(8, -16), vectorC);
    }

    @Test
    public void division() {
        vectorA.division(2);
        assertEquals(new Vector(0.5, 1, 1.5), vectorA);
        vectorC.division(5);
        assertEquals(new Vector(0.2, -0.4), vectorC);
    }

    @Test
    public void module() {
        assertEquals(3, new Vector(1, -2, 2).module(), 1e-5);
        assertEquals(5, new Vector(3, 4).module(), 1e-5);
    }

    @Test
    public void scalarProduct() {
        assertEquals(38, vectorA.scalarProduct(vectorB), 1e-5);
        assertEquals(128, vectorB.scalarProduct(vectorF), 1e-5);
    }

    @Test
    public void vectorProduct() {
        assertEquals(new Vector(-12, 6, 0), Vector.vectorProduct(vectorA, vectorB));
        assertEquals(new Vector(22, 4, -20), Vector.vectorProduct(vectorB, vectorF));
    }

}