package com.example.seii_einzelnbeispiel;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RechnerTest {
    Rechner rechner;

    @Before
    public void setup(){
        rechner = new Rechner();
    }

    @Test
    public void testValidMatriculationNumberSum(){
        int result = rechner.querSumme("12345678");

        assertEquals(36, result);
    }

    @Test
    public void testEmptyMatriculationNumberSum(){
        int result = rechner.querSumme("");

        assertEquals(0, result);
    }

    @Test
    public void testIntToBinary(){
        String result = rechner.intToBinary(24);

        assertEquals("11000", result);
    }

    @Test
    public void testZeroToBinary(){
        String result = rechner.intToBinary(0);

        assertEquals("0", result);
    }

    @Test
    public void testMatriculationNumberToSumToBinary(){
        int sum = rechner.querSumme("11830552");
        String result = rechner.intToBinary(sum);

        assertEquals("11001", result);
    }
}