package com.oocl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final int MAX_CHANCES = 6;
    private static final String CORRECT_OUTPUT = "4A0B";
    private static final String WINNING_MESSAGE = "Congrats, you win";
    private static final String ASK_INPUT_MESSAGE = "Please input your guess: ";

    public static void main( String[] args ) throws IOException {
        GuessNumberGame game = new GuessNumberGame();
        System.out.println(game.getAnswer());
        int chances = MAX_CHANCES;
        String result;

        while(chances > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(ASK_INPUT_MESSAGE);
            String input = reader.readLine();
            game.receiveInput(input);
            result = game.getOutput();

            if (result.equals(CORRECT_OUTPUT)) {
                System.out.println(WINNING_MESSAGE);
                break;
            } else {
                chances -= 1;
                System.out.println(result);
            }
        }
    }
}
