package com.memmatch;

import com.memmatch.app.MemMatchApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LeaderBoard implements Serializable {
    private static final String leaderFile = "data/LeaderBoard.dat"; // data file for the leaderBoard

    public static LeaderBoard getInstance() {
        //if the file exist, read it, otherwise create a new leaderBoard
        LeaderBoard leader = null;
        if (Files.exists(Path.of(leaderFile))) {
            try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(leaderFile))) {
                leader = (LeaderBoard) data.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            leader = new LeaderBoard();
        }
        return leader;
    }

    private LeaderBoard() {
    }

    Map<String, Double> leaderMap = new LinkedHashMap<>();

    public void update(String name, double score) {
        leaderMap.put(name, score);
        save();
    }

    public void show() {
        if (leaderMap.isEmpty()) {
            System.out.println("There are currently no rankings to show");
            System.out.println("========================================");
            System.out.println();
        } else {
            System.out.println("LEADER BOARD");
            System.out.println("============\n");
            System.out.printf("%-10s %-6s%n", "Name", "Score");
            System.out.println("--------------------");

            leaderMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //descending order
                    .forEach(entry -> System.out.printf("%-10s %-6s%n", entry.getKey(), entry.getValue()));
        }
    }

    private void save() {
        try (ObjectOutputStream newPlayer = new ObjectOutputStream(new FileOutputStream(leaderFile))) {
            newPlayer.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

