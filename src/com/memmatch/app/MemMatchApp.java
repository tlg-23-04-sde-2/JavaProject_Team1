package com.memmatch.app;

import com.memmatch.Board;

import java.util.Locale;
import java.util.Scanner;


public class MemMatchApp {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        startGame();
    }

    private void playAgain() {
        boolean validInput = false;
        while(!validInput){
            System.out.println("Would you like to play again? [Y/N]");
            String input = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
            if (input.matches("Y")){
                validInput = true;
                execute();
            }
            else{
                System.exit(0);
            }
        }
    }

    private void startGame() {
        Board.update();
    }

    private void welcome() {
        System.out.println("Please Enjoy Our Memory Match Game");
        System.out.println("==================================\n");
    }
}