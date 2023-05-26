package com.memmatch;

import java.util.Scanner;

class Player {

    private int getGuess() {
        int guess = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter a number [0-5]: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d")){
                guess = Integer.parseInt(input);
                if (1 <= guess && guess <= 5) {
                    validInput = true;
                }
            }
        }
        return guess;
    }

}