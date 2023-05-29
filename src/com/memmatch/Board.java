package com.memmatch;

import com.memmatch.app.MemMatchApp;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Board {
    public static Object showLeader;
    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_NUMBER = 10;


    public static void show() {
        Random random = new Random();
        int targetNumber = random.nextInt(MAX_NUMBER) + 1;
        int score = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Guess a number between 1 and " + MAX_NUMBER);

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            int guess = MemMatchApp.promptForGuess();
            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                score = calculateScore(attempt);
                Player.setScore(score);
                break;
            } else {
                System.out.println("Incorrect guess. Try again!");
            }
        }

        System.out.println("Game over!");
        System.out.println("Your score: " + score);
    }

    public static int calculateScore(int attempts) {
        int maxScore = 100;
        int scorePerAttempt = maxScore / MAX_ATTEMPTS;
        return maxScore - (attempts - 1) * scorePerAttempt;
    }
}
