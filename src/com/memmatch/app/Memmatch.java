package com.memmatch.app;

import com.memmatch.Board;
import com.memmatch.Player;

import java.util.Scanner;

 public class Memmatch {
     private final Scanner scanner1 = new Scanner(System.in);
     private final Board board = Board.getInstance();
     Player player = new Player();

     public void execute() {
         //instantiate controller and say "go"
         welcome();
         player.setName();
         showBoard();
         player.getGuess();
     }

     public void welcome(){
         System.out.println("Welcome to this wonderful memory game");
     }

     public void showBoard(){
         System.out.println("The board show show the level and name of the player");
     }
}