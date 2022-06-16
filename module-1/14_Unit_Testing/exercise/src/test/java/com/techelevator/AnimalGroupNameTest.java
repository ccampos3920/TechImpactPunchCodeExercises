package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class AnimalGroupNameTest {
    AnimalGroupName exercise = new AnimalGroupName();
    @Test
    public void AnimalGroupName() {
        assertEquals(("Input: getHerd(\"rhino\")"), "Crash",exercise.getHerd("rhino"));
        assertEquals(("Input: getHerd(\"walrus\")"), "unknown",exercise.getHerd("walrus"));
        assertEquals(("Input: getHerd(\"dog\")"), "Pack",exercise.getHerd("dog"));
        assertEquals(("Input: getHerd(\"Rhino\")"), "Crash",exercise.getHerd("Rhino"));
        assertEquals(("Input: getHerd(\"\")"), "unknown",exercise.getHerd(""));
        assertEquals(("Input: getHerd(\"OwenWilson\")"), "unknown",exercise.getHerd("OwenWilson"));
        assertEquals(("Input: getHerd(\"Giraffe\")"), "Tower",exercise.getHerd("Giraffe"));
        assertEquals(("Input: getHerd(\"Lion\")"), "Pride", exercise.getHerd("Lion"));

    }
}