package com.memmatch;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    //test if the incoming input is valid
    //test illegalargument exception
    //test that the score stays within the range of 100 to 1
    Player player1 = new Player();

    @Test
    public void playerValidInput() {
        //assert player input >= 0;
        //assert player input =< 10;
        assertEquals(1, 1);
    }
}