package com.memmatch;

import java.util.Scanner;

public class Player {
    static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    private final Scanner scanner = new Scanner(System.in);
    private int attempts;
    private String name;

    public int promptForGuess(String[] board, boolean[] isFlipped) throws IllegalArgumentException {
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please select the card you would like to flip, the cards are listed 0 through "
                        + (board.length - 1) + ":");
                attempts++;
                String input = scanner.nextLine().trim();
                guess = Integer.parseInt(input);
                if (guess < 0 || guess >= board.length) {
                    throw new IllegalArgumentException();
                } else if (isFlipped[guess]) {
                    System.out.println("The card you selected has already been flipped, please choose another card.");
                } else {
                    validInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
        return guess;
    }

    public int calculateScore() {
        //must be within 100-1
        int maxScore = 100;
        return maxScore - attempts;
    }
}