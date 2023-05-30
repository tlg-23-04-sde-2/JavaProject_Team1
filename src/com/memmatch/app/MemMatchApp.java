package com.memmatch.app;

import com.memmatch.Board;
import com.memmatch.LeaderBoard;
import com.memmatch.Player;

import java.util.Scanner;

public class MemMatchApp {
    private static final Scanner scanner = new Scanner(System.in);
    private final LeaderBoard leader = LeaderBoard.getInstance();
    private static final int MIN = 1;
    private static final int MAX = 10;

    public void execute() {
        welcome();
        showLeaderBoard();
        String name = promptForName();
        showBoard();
        updateBoard(name, Player.getScore());
        thankYou(name);
        showLeaderBoard();
    }


    private void updateBoard(String name, int score) {
        leader.update(name, score);
    }

    public static int promptForGuess() {
        int guess = 0;

        boolean validGuess = false;
        while (!validGuess) {
            System.out.print("Please enter your guess: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1,2}")) {
                guess = Integer.parseInt(input);
                if (MIN <= guess && guess <= MAX) {
                    validGuess = true;
                }
            }
        }

        return guess;
    }


    private void showBoard() {
        Board.show();
    }

    private String promptForName() {
        String playerName = null;
        boolean validName = false;
        while (!validName) {
            System.out.println("Please Enter your Name: ");
            String inputName = scanner.nextLine().trim().toUpperCase();
            if (inputName.length() >= 1) {
                validName = true;
                playerName = inputName;
            }
        }
        return playerName;
    }

    private void showLeaderBoard() {
        leader.show();
    }

    private void thankYou(String name) {
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("THANK YOU FOR PLAYING " + "'" + name.toUpperCase() + "'" + " TRY AGAIN FOR A HIGHER SCORE");
        System.out.println("==========================================================");
        System.out.println();

    }

    private void welcome() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("W E L C O M E - T O - T H E - M E M M A T C H - A P P L I C A T I O N");
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

}