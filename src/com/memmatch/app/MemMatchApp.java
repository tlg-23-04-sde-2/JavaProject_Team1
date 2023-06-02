package com.memmatch.app;

import com.memmatch.Board;
import com.memmatch.LeaderBoard;
import com.memmatch.Player;

import java.util.Locale;
import java.util.Scanner;


public class MemMatchApp {
    static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    private final Scanner scanner = new Scanner(System.in);
    private final LeaderBoard leader = LeaderBoard.getInstance();
    private final Board board = new Board();
    private final int MIN_LENGTH = 2;
    private final int MAX_LENGTH = 11;


    public void execute() {
        welcome();
        rules();
        showLeaderBoard();
        String name = promptForName();
        startGame(); // gameBoard
        updateLeaderBoard(name, Player.calculateScore());
        thankYou(name);
        showLeaderBoard();
        playAgain(); // gameBoard
    }

    public void playAgain() {
        boolean validInput = false;

        if(Board.gameFinished) {
            while (!validInput) {
                System.out.println("Would you like to play again? [Y/N]");
                String input = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                if (input.matches("Y")) {
                    validInput = true;
                    execute();
                } else {
                    System.exit(0);
                }
            }
        }
    }

    private void startGame() {
        board.update();
    }

    public String promptForName() {
        String playerName = null;
        boolean validName = false;
        while (!validName) {
            System.out.println("Please Enter your Name: ");
            String inputName = scanner.nextLine().trim().toUpperCase();
            if (inputName.length() >= MIN_LENGTH && inputName.length() <= MAX_LENGTH) {
                validName = true;
                playerName = inputName;
            } else {
                System.out.println(inputName + " Not a valid Name - Name must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
            }
        }
        return playerName;
    }

    private void updateLeaderBoard(String name, int score) {
        leader.update(name, score);
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

    private void rules(){
        System.out.println("To play this game the rules are as follows: ");
        System.out.println("Each level you will be presented with a set of cards with a varying number of pairs.");
        System.out.println("each turn, the player will flip 2 cards individually to attempt to match these pairs.");
        System.out.println("If a match is made, the cards will remain face up.");
        System.out.println("If a match is not made, then the cards will return to being face down.");
        System.out.println("Once all pairs in the set are found, you will progress to the next level.");
        System.out.println("Each player will be start with 100 points, every attempt taken to match a pair will subtract from the 100.");
        System.out.println("Once the game is completed, the remainder of the 100 will be saved to the leaderboard as your score.");

    }
}