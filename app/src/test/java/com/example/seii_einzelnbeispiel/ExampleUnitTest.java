package com.example.seii_einzelnbeispiel;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.widget.TextView;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testValidMatriculationNumberSum(){
        Rechner rechner = new Rechner(null);
        int result = rechner.querSumme("12345678");
        assertEquals(36, result);
    }

    @Test
    public void testEmptyMatriculationNumberSum(){
        Rechner rechner = new Rechner(null);
        int result = rechner.querSumme("");
        assertEquals(0, result);
    }
}