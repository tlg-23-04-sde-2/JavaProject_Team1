package com.memmatch;

import com.memmatch.app.MemMatchApp;

import java.util.ArrayList;
import java.util.Collections;

public class Board{
    //properties
    private static int level = 1;
    private static int pairs = 2;
    private static int matchMade = 0;
    public static boolean gameFinished = false;


    public static final ArrayList<String> cards = new ArrayList<>();
    private static String[] board;
    public static boolean[] isFlipped;

    //constructor - private to prevent outside instantiation.
    public Board(){
        //left blank intentionally
    }

    //accessor methods
    public static int getLevel() {
        return level;
    }

    //business methods
    public static void getCards() {
        if (level == 1) {

            cards.add("1");
            cards.add("1");
            cards.add("2");
            cards.add("2");
//            cards.add("3");
//            cards.add("3");
            pairs = 2;
        }
        if (level == 2){
            cards.add("4");
            cards.add("4");
//            cards.add("5");
//            cards.add("5");
            pairs = 3;
        }
        if (level == 3){
            cards.add("6");
            cards.add("6");
//            cards.add("7");
//            cards.add("7");
            pairs = 4;
        }
        Collections.shuffle(cards);
        board = new String[cards.size()];
        isFlipped = new boolean[cards.size()];
    }

    public static void update(){
        Player player = new Player();
        getCards();

        while (matchMade < pairs) {
            show(board);

            int card1 = player.promptForGuess(board,isFlipped);
            board[card1] = cards.get(card1);
            isFlipped[card1] = true;
            show(board);

            int card2 = player.promptForGuess(board, isFlipped);
            board[card2] = cards.get(card2);
            isFlipped[card2] = true;
            show(board);

            if (board[card2].equals(board[card1])) {
                System.out.println("You have found a match, keep it up.\n");
                matchMade++;
            } else {
                System.out.println("sorry that was not a match, please try again.\n");
                board[card1] = " ";
                isFlipped[card1] = false;
                board[card2] = " ";
                isFlipped[card2] = false;
            }
        }
        if (matchMade == pairs) {
            System.out.println("You have beat level:" + getLevel());
            loadNextLevel();
        }
    }

    private static void loadNextLevel() {
        if (level < 3){
            System.out.println("Now loading next level.");
            System.out.println();
            matchMade = 0;
            level++;
            update();
        }
        else{
            System.out.println("Congratulations you have beat the game.");
            level = 0;
            cards.clear();
            gameFinished = true;
        }
    }

    public static void show(String[] board) {
        System.out.println("Current Level: " + getLevel());
        for (String integer : board) {
            System.out.print("| " + integer + " |");
        }
        System.out.println();
    }
}