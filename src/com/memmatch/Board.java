package com.memmatch;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;

public class Board<cards> {
    //properties
    private static int level = 1;
    private static int pairs = 3;
    private static int matchMade = 0;

    private static ArrayList<Integer> cards = new ArrayList<>();
    private static Integer[] board;
    private static boolean[] isFlipped = new boolean[cards.size()];

    //constructor - private to prevent outside instantiation.
    public Board(){
        //left blank intentionally
    }

    //accessor methods
    public static int getLevel() {
        return level;
    }

    //business methods
    private static void getCards() {
        if (level == 1) {

            cards.add(1);
            cards.add(1);
            cards.add(2);
            cards.add(2);
            cards.add(3);
            cards.add(3);
            pairs = 3;
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
            pairs = 6;
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
            pairs = 12;
        }
        Collections.shuffle(cards);
        board = new Integer[cards.size()];
    }

    public static void update(){
        Player player = new Player();


        while (matchMade < pairs) {
            getCards();
            show(board);

            int card1 = player.getGuess();
            board[card1] = cards.get(card1);
            isFlipped[card1] = true;
            show(board);

            int card2 = player.getGuess();
            board[card2] = cards.get(card2);
            isFlipped[card2] = true;
            show(board);

            if (board[card2].equals(board[card1])) {
                System.out.println("You have found a match, keep it up.");
                matchMade++;
            } else {
                board[card1] = 0;
                isFlipped[card1] = false;
                board[card2] = 0;
                isFlipped[card2] = false;
            }
        }
        System.out.println("You have beat level:" + getLevel());
        loadNextLevel();
    }

    private static void loadNextLevel() {
        if (level < 3){
            System.out.println("Now loading next level.");
            level++;
        }
        else{
            System.out.println("Congratulations you have beat the game.");
        }
    }

    public static void show(Integer[] board) {
        System.out.println("Current Level: " + getLevel());
        for (int i = 0; i < board.length; i++) {
            System.out.print("| " + board[i] + " |");
        }
        System.out.println();
    }
}