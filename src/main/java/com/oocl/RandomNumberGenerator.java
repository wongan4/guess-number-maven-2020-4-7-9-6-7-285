package com.oocl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {
    public String getRandomNumberInString () {
        Random random = new Random();
        Set<String> randomNumbers = new HashSet<String>();

        while (randomNumbers.size() < 4) {
            randomNumbers.add(String.valueOf(random.nextInt(10)));
        }

        return String.join("", randomNumbers);
    }
}
