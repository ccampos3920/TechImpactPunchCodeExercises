package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;


public class DateFashionTest {
    DateFashion exercise = new DateFashion();

    @Test
    public void DateFashionTest(){
        assertEquals(("Input: getATable(5, 10)"),2,  exercise.getATable(5, 10));
        assertEquals(("Input: getATable(5, 2)"),0,  exercise.getATable(5, 2));
        assertEquals(("Input: getATable(5, 5)"),1,  exercise.getATable(5, 5));

    }
}
