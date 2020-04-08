package com.oocl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final int MAX_CHANCES = 6;
    private static final String CORRECT_OUTPUT = "4A0B";

    public static void main( String[] args ) throws IOException {
        int chances = MAX_CHANCES;
        String result;

        while(chances > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please input your guess: ");
            String input = reader.readLine();
            GuessNumberGame game = new GuessNumberGame();
            game.receiveInput(input);
            result = game.getOutput();

            if (result.equals(CORRECT_OUTPUT)) {
                System.out.println("Congrat, you win");
                break;
            } else {
                chances -= 1;
                System.out.println(result);
            }
        }
    }
}
