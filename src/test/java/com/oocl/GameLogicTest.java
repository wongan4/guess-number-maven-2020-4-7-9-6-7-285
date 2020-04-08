package com.oocl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {
    private static final String JUNIT_TEST_ANSWER = "4629";
    private GuessNumberGame game;

    @Before
    public void setup() {
        this.game = new GuessNumberGame(JUNIT_TEST_ANSWER);
    }

    @Test
    public void should_win_game_when_correct_input() {
        String input = JUNIT_TEST_ANSWER;
        this.game.receiveInput(input);
        assertEquals("4A0B", this.game.getOutput());
    }
}