package com.memmatch;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    //test illegalargument exception
    //test that the score stays within the range of 100 to 1
    Player player1 = new Player();
    private static ArrayList<String> cards;
    private static String[] board;
    private static boolean[] isflipped1;

    @Before
    public void init() {
        cards = new ArrayList<>();
        cards.add("1");
        cards.add("1");
        cards.add("2");
        cards.add("2");
        cards.add("3");
        cards.add("3");
        board = new String[cards.size()];

        isflipped1 = new boolean[3];
    }

    @Test
    public void invalidInputException_nonNumeric_andNumeric() {
        String userInput = "Hello\n1\n";
        InputStream input = new ByteArrayInputStream(userInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream outPut = new PrintStream(captured);
        System.setOut(outPut);
        Player player2 = new Player();
        int selection = player2.promptForGuess(board, isflipped1);
        assertEquals(1, selection);
        String displayedText = captured.toString(StandardCharsets.UTF_8);
        assertTrue(displayedText.contains(Player.INVALID_INPUT_MESSAGE));
    }
}