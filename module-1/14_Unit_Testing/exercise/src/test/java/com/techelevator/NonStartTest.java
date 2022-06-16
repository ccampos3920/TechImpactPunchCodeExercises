package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class NonStartTest {
    NonStart exercise = new NonStart();
    @Test
    public void NonStart(){
        assertEquals(("Input: GetPartialString(\"Hello\", \"There\")"), "ellohere", exercise.getPartialString("Hello", "There"));
        assertEquals(("Input: GetPartialString(\"java\", \"code\")"), "avaode", exercise.getPartialString("java", "code"));
        assertEquals(("Input: GetPartialString(\"shotl\", \"java\")"), "hotlava", exercise.getPartialString("shotl", "java"));

    }

}
