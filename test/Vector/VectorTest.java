package Vector;

import org.junit.Test;

import static org.junit.Assert.*;


public class VectorTest {
    @Test
    public void test1() throws Exception {
        Vector tester = new Vector();
        assertEquals(3, tester.test(1, 2));
        assertEquals(111, tester.test(50, 61));
    }

}