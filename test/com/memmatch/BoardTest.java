package com.memmatch;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest {
    private static ArrayList<String> cards;
    private static String[] board;
    private static int level = 1;

    @Before
    public void init(){
        cards = new ArrayList<>();
        cards.add("1");
        cards.add("1");
        cards.add("2");
        cards.add("2");
        cards.add("3");
        cards.add("3");
        board = new String[cards.size()];
    }

    @Test
    public void showBoardTest() {
        Board.show(board);
    }
}