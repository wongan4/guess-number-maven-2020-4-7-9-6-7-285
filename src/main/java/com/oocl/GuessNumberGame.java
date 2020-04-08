package com.oocl;

import java.util.HashMap;

public class GuessNumberGame {
    private static final String ERR_MESSAGE_INVALID_INPUT = "Wrong Input，Input again";
    private static final String DEFAULT_ANSWER = "1234";
    private final String answer;
    private String input;
    private String output;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public GuessNumberGame() {
        this.answer = DEFAULT_ANSWER;
    }

    public void receiveInput(String rawInput) {
        if (rawInput.length() != 4 || isContainDuplicate(rawInput)) {
            this.output = ERR_MESSAGE_INVALID_INPUT;
        } else {
            this.input = rawInput;
        }

        validateInput();
    }

    private boolean isContainDuplicate(String rawInput) {
        HashMap<Character, Integer> inputNumberCount = new HashMap<Character, Integer>();
        for (Character inputNumber : rawInput.toCharArray()) {
            if (inputNumberCount.containsKey(inputNumber)) {
                return true;
            } else {
                inputNumberCount.put(inputNumber, 1);
            }
        }
        return false;
    }

    private void validateInput() {
        int correctPositionNumberCount = countCorrectPositionNumber();
    }

    public int countCorrectPositionNumber() {
        return 0;
    }

    public String getOutput() {
        return this.output;
    }

    public String getAnswer() {
        return this.answer;
    }
}
