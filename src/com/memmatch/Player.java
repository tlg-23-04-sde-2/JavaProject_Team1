package com.memmatch;

public class Player {

    private static String name;
    private static Object guess;
    private static int score = 0;

    public Player(String name, int score) {
        Player.score = score;
        setName(name);
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static Object getGuess() {
        return guess;
    }

    public static void setGuess(Object guess) {
        Player.guess = guess;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Player.score = score;
    }
}