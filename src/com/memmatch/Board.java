package com.memmatch;

import java.util.ArrayList;
import java.util.Collections;

public class Board<cards> {
    //properties
    private int level = 1;
    static int matchMade = 0;
    Integer[] board;
    boolean[] isFlipped;
    private static ArrayList<Integer> cards = new ArrayList<>();


    private void getBoard() {
        if (level == 1) {

            cards.add(1);
            cards.add(1);
            cards.add(2);
            cards.add(2);
            cards.add(3);
            cards.add(3);
        }
        if (level == 2){
            cards.add(1);
            cards.add(1);
            cards.add(2);
            cards.add(2);
            cards.add(3);
            cards.add(3);
            cards.add(4);
            cards.add(4);
            cards.add(5);
            cards.add(5);
            cards.add(6);
            cards.add(6);
        }
        if (level == 3){
            cards.add(1);
            cards.add(1);
            cards.add(2);
            cards.add(2);
            cards.add(3);
            cards.add(3);
            cards.add(4);
            cards.add(4);
            cards.add(5);
            cards.add(5);
            cards.add(6);
            cards.add(6);
            cards.add(7);
            cards.add(7);
            cards.add(8);
            cards.add(8);
            cards.add(9);
            cards.add(9);
            cards.add(10);
            cards.add(10);
            cards.add(11);
            cards.add(11);
            cards.add(12);
            cards.add(12);
        }
        Collections.shuffle(cards);


    }

    private static void update(){
        while (matchMade < (cards.size()/2)){
            showBoard(board);
            int card1 = getGuess(scanner, board, isFlipped,"message to player");

        }
    }

    private static void showBoard(Integer[] board) {
        for (int i = 0; i < board.length; i++){
            System.out.println("| " + board[i] + " |");
        }
    }


}