package com.oocl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator implements AnswerGeneratorInterface {
    private static final int MAX_NUMBER_LENGTH = 4;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final String RANDOM_NUMBER_DELIMITER = "";

    public String generateAnswer () {
        Random random = new Random();
        Set<String> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < MAX_NUMBER_LENGTH) {
            randomNumbers.add(String.valueOf(random.nextInt(RANDOM_NUMBER_UPPER_BOUND)));
        }

        return String.join(RANDOM_NUMBER_DELIMITER, randomNumbers);
    }
}
