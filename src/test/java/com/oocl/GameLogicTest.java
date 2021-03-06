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
    public void should_generate_random_answer() {
        RandomNumberGenerator answerGenerator = new RandomNumberGenerator();
        GuessNumberGame gameWithRandomAnswer = new GuessNumberGame(answerGenerator);
        assertNotEquals(JUNIT_TEST_ANSWER, gameWithRandomAnswer.getAnswer());
    }

    @Test
    public void should_output_correct_when_correct_input() {
        String input = JUNIT_TEST_ANSWER;
        this.game.receiveInput(input);
        assertEquals("4A0B", this.game.getOutput());
    }

    @Test
    public void should_output_correct_when_all_number_wrong() {
        String input = "5138";
        this.game.receiveInput(input);
        assertEquals("0A0B", this.game.getOutput());
    }

    @Test
    public void should_output_correct_when_correct_number_but_all_position_wrong() {
        String input = "9264";
        this.game.receiveInput(input);
        assertEquals("0A4B", this.game.getOutput());
    }

    @Test
    public void should_output_correct_when_some_correct_position_some_not() {
        String input = "4692";
        this.game.receiveInput(input);
        assertEquals("2A2B", this.game.getOutput());
    }
}