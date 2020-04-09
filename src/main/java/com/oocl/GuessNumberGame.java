package com.oocl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class GuessNumberGame {
    private static final String ERR_MESSAGE_INVALID_INPUT = "Wrong Input，Input again";
    private static final String DEFAULT_ANSWER = "3472";
    private final String answer;
    private String input;
    private String output;

    public GuessNumberGame(String answer) {
        this.answer = answer;
    }

    public GuessNumberGame() {
        this.answer = DEFAULT_ANSWER;
    }

    public GuessNumberGame(AnswerGeneratorInterface answerGeneratorInterface) {
        this.answer = answerGeneratorInterface.generateAnswer();
    }

    public void receiveInput(String rawInput) {
        if (rawInput.length() != 4 || isContainDuplicate(rawInput)) {
            this.output = ERR_MESSAGE_INVALID_INPUT;
            return;
        }

        this.input = rawInput;
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
        int sameNumberCount = countSameNumber();
        this.output = correctPositionNumberCount + "A" + (sameNumberCount - correctPositionNumberCount) + "B";
    }

    public int countCorrectPositionNumber() {
        int count = 0;

        for (Character number : this.input.toCharArray()) {
            int index = this.input.indexOf(number);
            if (number.equals(this.answer.charAt(index))) {
                count += 1;
            }
        }

        return count;
    }

    public int countSameNumber() {
        int count = 0;

        for (Character number : this.input.toCharArray()) {
            if (this.answer.contains(number.toString())) {
                count += 1;
            }
        }

        return count;
    }

    public String getOutput() {
        return this.output;
    }

    public String getAnswer() {
        return this.answer;
    }
}
