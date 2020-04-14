package com.oocl;

import java.util.HashMap;

class GuessNumberGame {
    private static final String ERR_MESSAGE_INVALID_INPUT = "Wrong Input，Input again";
    private static final String DEFAULT_ANSWER = "3472";
    private static final int INPUT_LENGTH = 4;
    private final String answer;
    private String input;
    private String output;
    private RandomNumberGenerator randomNumberGenerator;

    GuessNumberGame(String answer) {
        this.answer = answer;
    }

    GuessNumberGame() {
        this.answer = DEFAULT_ANSWER;
    }

    GuessNumberGame(AnswerGeneratorInterface answerGeneratorInterface) {
        this.answer = answerGeneratorInterface.generateAnswer();
    }

    void receiveInput(String rawInput) {
        if (rawInput.length() != INPUT_LENGTH || isContainDuplicate(rawInput)) {
            this.output = ERR_MESSAGE_INVALID_INPUT;
            return;
        }

        this.input = rawInput;
        processInput();
    }

    private boolean isContainDuplicate(String rawInput) {
        HashMap<Character, Integer> inputNumberCount = new HashMap<>();
        for (Character inputNumber : rawInput.toCharArray()) {
            if (inputNumberCount.containsKey(inputNumber)) {
                return true;
            }
            inputNumberCount.put(inputNumber, 1);
        }
        return false;
    }

    private void processInput() {
        int correctPositionNumberCount = countCorrectPositionNumber();
        int sameNumberCount = countSameNumber();
        this.output = correctPositionNumberCount + "A" + (sameNumberCount - correctPositionNumberCount) + "B";
    }

    private int countCorrectPositionNumber() {
        int count = 0;

        for (Character number : this.input.toCharArray()) {
            int index = this.input.indexOf(number);
            if (number.equals(this.answer.charAt(index))) {
                count += 1;
            }
        }

        return count;
    }

    private int countSameNumber() {
        int count = 0;

        for (Character number : this.input.toCharArray()) {
            if (this.answer.contains(number.toString())) {
                count += 1;
            }
        }

        return count;
    }

    String getOutput() {
        return this.output;
    }

    String getAnswer() {
        return this.answer;
    }
}
