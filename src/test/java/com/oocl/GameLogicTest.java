package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {
    private GuessNumberGame game;

    @Before
    public void setup() {
        this.game = new GuessNumberGame();
    }

    @Test
    public void should_block_incomplete_input() {
        String input = "1 2";
        this.game.receiveInput(input);

        assertEquals("Wrong Input，Input again", this.game.getOutput());
    }
}