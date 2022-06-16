package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class Lucky13Test {
    Lucky13 exercise = new Lucky13();

    @Test
    public void Lucky13Test(){
        assertEquals(("Input: ([0, 2, 4])"), true, exercise.getLucky(new int[]{0,2,4}));
        assertEquals(("Input: ([1, 2, 3])"), false, exercise.getLucky(new int[]{1,2,3}));
        assertEquals(("Input: ([1, 2, 4])"), false, exercise.getLucky(new int[]{1,2,4}));

    }

}
