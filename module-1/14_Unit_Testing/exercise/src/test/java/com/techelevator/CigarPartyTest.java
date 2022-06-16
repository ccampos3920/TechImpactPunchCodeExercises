package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class CigarPartyTest {
    CigarParty exercise = new CigarParty();
    @Test
    public void CigarPartyTest() {
        assertEquals(("Input: haveParty(30, false)"),false,exercise.haveParty(30, false));
        assertEquals(("Input: haveParty(50, false)"),true,exercise.haveParty(50, false));
        assertEquals(("Input: haveParty(70, true)"),true,exercise.haveParty(70, true));



    }
}
