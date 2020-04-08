package com.oocl;

public class GuessNumberGame {
    private static final String ERR_MESSAGE_INVALID_INPUT = "Wrong Input，Input again";
    private String input;
    private String output;

    public void receiveInput(String input) {
        if (input.split(" ").length != 4) {
            this.output = ERR_MESSAGE_INVALID_INPUT;
        } else {

        }
    }

    public String getOutput() {
        return this.output;
    }
}
