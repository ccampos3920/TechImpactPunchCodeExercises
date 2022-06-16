package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class StringBitsTest{
    StringBits exercise = new StringBits();

    @Test
public void getBits(){
        assertEquals(("Input: getBits(\"Heeololeo\")"), "Hello",exercise.getBits("Heeololeo"));
        assertEquals(("Input: getBits(\"Hello\")"), "Hlo",exercise.getBits("Hello"));
        assertEquals(("Input: getBits(\"Hi\")"), "H",exercise.getBits("Hi"));

    }



}