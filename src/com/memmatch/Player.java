package com.memmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final Scanner scanner = new Scanner(System.in);
    private String name;

    //Constructors
    public Player() {
        //call to super
    }

    //business or action methods


    // accessor methods
    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Please enter the name of the Player: ");
        name = scanner.nextLine().trim();

    }

    public int getGuess() {
        int guess = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter a number from [0-5]: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d")) {
                guess = Integer.parseInt(input);
                if (0 <= guess && guess <= 5) {
                    validInput = true;
                }
            }
        }
        return guess;
    }
}