package com.memmatch;

import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);
    private static int attempts;

    public int promptForGuess(String[] board, boolean[] isFlipped) throws IllegalArgumentException {
        int guess = 0;
        boolean validInput = false;

        try {
            while (!validInput) {
                System.out.println("Please select the card you would like to flip, the cards are listed 0 through " + (board.length - 1) + ":");
                String input = scanner.nextLine().trim();
                if (input.matches("\\d")) {
                    guess = Integer.parseInt(input);
                    if (guess < 0 || guess >= board.length) {
                        System.out.println("Invalid guess, please enter a valid card number 0 through " + (board.length - 1) + ":");
                    }
                    if (isFlipped[guess]) {
                        System.out.println("The card you selected has already been flipped, please choose another card.");
                    } else {
                        validInput = true;
                    }
                }
                attempts++;
                return guess;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return guess;
    }

    public static int calculateScore() {
        //must be within 100-1
        int maxScore = 100;
        return maxScore - attempts;
    }
}