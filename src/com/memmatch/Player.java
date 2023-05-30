package com.memmatch;

import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);
    private int attempts;

    public int promptForGuess(String[] board, boolean[] isFlipped) throws IllegalArgumentException {
        int guess = 0;
        attempts++;
        boolean validInput = false;

        try {
            while (!validInput) {
                System.out.println("Please select the card you would like to flip, the cards are listed 0 through " + (board.length - 1) + ":");
                guess = scanner.nextInt();
                if (guess < 0 || guess >= board.length) {
                    System.out.println("Invalid guess, please enter a valid card number 0 through " + (board.length - 1) + ":");
                }
                if (isFlipped[guess]) {
                    System.out.println("The card you selected has already been flipped, please choose another card.");
                } else {
                    validInput = true;
                }
            }
            return guess;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return guess;
    }

    public int calculateScore() {
        int maxScore = 100;
        return maxScore - this.attempts;
    }

}