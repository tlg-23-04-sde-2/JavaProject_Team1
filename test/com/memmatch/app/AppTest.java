package com.memmatch.app;

import com.memmatch.Player;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AppTest {

    @Test(expected = IllegalArgumentException.class)
    public void promptForName_ShouldPrintThatInputIsNotValidAndToEntervalidName_whenInputIs12Characters() {

        String userInput = "christopherr\n";
        InputStream input = new ByteArrayInputStream(userInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream outPut = new PrintStream(captured);
        System.setOut(outPut);
        MemMatchApp player = new MemMatchApp();
        player.promptForName();
        String displayedText = captured.toString(StandardCharsets.UTF_8);
        assertTrue(displayedText.contains(MemMatchApp.INVALID_INPUT_MESSAGE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void promptForName_ShouldPrintThatInputIsNotValidAndToEntervalidName_whenInputIs1Character() {

        String userInput = "r\n";
        InputStream input = new ByteArrayInputStream(userInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream outPut = new PrintStream(captured);
        System.setOut(outPut);
        MemMatchApp player = new MemMatchApp();
        player.promptForName();
        String displayedText = captured.toString(StandardCharsets.UTF_8);
        assertTrue(displayedText.contains(MemMatchApp.INVALID_INPUT_MESSAGE));
    }
}