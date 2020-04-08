package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOTest {
    private static final String ERR_MESSAGE_INVALID_INPUT = "Wrong Input，Input again";

    private GuessNumberGame game;

    @Before
    public void setup() {
        this.game = new GuessNumberGame();
    }

    @Test
    public void should_block_incomplete_input() {
        String input = "1 2 ";
        this.game.receiveInput(input);
        assertEquals(ERR_MESSAGE_INVALID_INPUT, this.game.getOutput());
    }

    @Test
    public void should_block_empty_input() {
        String input = "";
        this.game.receiveInput(input);
        assertEquals(ERR_MESSAGE_INVALID_INPUT, this.game.getOutput());
    }
}