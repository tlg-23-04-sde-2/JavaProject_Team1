package com.memmatch;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Board {
    public static Board getInstance() {
        Board board = new Board();
        return board;
    }
}