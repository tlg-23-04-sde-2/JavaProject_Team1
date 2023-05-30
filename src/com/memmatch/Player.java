package com.memmatch;

import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);


    public int promptForGuess(String[] board, boolean[] isFlipped) {
        int guess = 0;
        boolean validInput = false;

        while(!validInput) {
            System.out.println("Please select the card you would like to flip, the cards are listed 0 through " + (board.length - 1) + ":");
            guess = scanner.nextInt();
            if (guess >= 0 && guess <= board.length) {
                validInput = true;
            }
            else if (isFlipped[guess]) {
                System.out.println("The card you selected has already been flipped, please choose another card.");
            }
            else{
                System.out.println("Invalid guess, please enter a valid card number 0 through " + (board.length - 1) + ":");
            }

        }
        return guess;
    }
}