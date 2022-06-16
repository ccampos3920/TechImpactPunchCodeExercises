package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class FrontTimesTest {
    FrontTimes exercise = new FrontTimes();

    @Test
    public void FrontTimesTest(){
        assertEquals(("Input: frontTimes(\"Chocolate\", 3)"), "ChoChoCho", exercise.generateString("Chocolate", 3));
        assertEquals(("Input: frontTimes(\"Chocolate\", 2)"), "ChoCho", exercise.generateString("Chocolate", 2));
        assertEquals(("Input: frontTimes(\"Abc\", 3)"), "AbcAbcAbc", exercise.generateString("Abc", 3));

    }

}
