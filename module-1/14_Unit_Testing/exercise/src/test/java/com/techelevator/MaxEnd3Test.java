package com.techelevator;

// Two required libraries
import org.junit.*;
import static org.junit.Assert.*;

// Public class, variable name is the main file name
public class MaxEnd3Test {
    // Always needed to give the data holder a variable name
    // to use bellow to call the data from the main file
    // and used to add the expected input
    MaxEnd3 exercise = new MaxEnd3();

    // required @ so it knows
    // the method below is for testing
    @Test
    // Method is listed below, the name is the file name followed by parenthesis
    public void MaxEnd3Test(){
        //This specific question uses assertArrayEquals since it's calling from an Array
    Assert.assertArrayEquals(new int[]{3, 3, 3}, exercise.makeArray(new int[] {1,2,3}));
    Assert.assertArrayEquals(new int[]{11, 11, 11}, exercise.makeArray(new int[] {11,5,9}));
    Assert.assertArrayEquals(new int[]{3, 3, 3}, exercise.makeArray(new int[] {2,11,3}));
    }
}
