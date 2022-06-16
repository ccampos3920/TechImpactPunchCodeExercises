package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class Less20Test {
    Less20 exercise = new Less20();

    @Test
    public void Less20Test(){
        assertEquals(("Input: less20(18)"), true, exercise.isLessThanMultipleOf20(18));
        assertEquals(("Input: less20(19)"), true, exercise.isLessThanMultipleOf20(19));
        assertEquals(("Input: less20(20)"), false, exercise.isLessThanMultipleOf20(20));
    }

}
