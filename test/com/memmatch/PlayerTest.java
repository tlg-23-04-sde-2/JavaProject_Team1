package com.memmatch;

import org.junit.Before;
import org.junit.Test;
import com.memmatch.Player;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PlayerTest {
    //test if the incoming input is valid
    //test illegalargument exception
    //test that the score stays within the range of 100 to 1
    private Player player1 = new Player();
    private static ArrayList<String> cards;
    private static String[] board;
    private static int level = 1;
    private static boolean[] isflipped1;
    private static final Scanner scanner1 = new Scanner(System.in);


    @Test
    public void playerValidInput() {

    }
}