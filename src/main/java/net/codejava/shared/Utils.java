package net.codejava.shared;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new Random();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateProductId(int length){return generateRandomString(length);}

    private String generateRandomString(int length) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {

            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(stringBuilder);
    }
}
