package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class SameFirstLastTest {
    SameFirstLast exercise = new SameFirstLast();

    @Test
    public void SameFirstLastTest(){
        assertEquals(("Input: IsItTheSame([1, 2, 3])"), false, exercise.isItTheSame(new int[]{1, 2, 3}));
        assertEquals(("Input: IsItTheSame([1, 2, 3, 1])"), true, exercise.isItTheSame(new int[]{1, 2, 3, 1}));
        assertEquals(("Input: IsItTheSame([1, 2, 1])"), true, exercise.isItTheSame(new int[]{1, 2, 1}));

    }
}
