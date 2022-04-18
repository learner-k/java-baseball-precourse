package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.Constants.NUMBERS_LENGTH;
import static baseball.Constants.NUMBER_END;
import static baseball.Constants.NUMBER_END_CHAR;
import static baseball.Constants.NUMBER_START;
import static baseball.Constants.NUMBER_START_CHAR;

public class Numbers {
    public static void validateNumbers(final String numbers) {
        validateNullOrEmpty(numbers);
        validateLength(numbers);
        validateCharacterRange(numbers);
        validateDuplicatedCharacter(numbers);
    }

    private static void validateNullOrEmpty(final String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("numbers is null or empty.");
        }
    }

    private static void validateLength(final String numbers) {
        if (numbers.length() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(String.format("numbers length must be %d.", NUMBERS_LENGTH));
        }
    }

    private static void validateCharacterRange(final String numbers) {
        for (char c : numbers.toCharArray()) {
            validateCharacterRange(c);
        }
    }

    private static void validateCharacterRange(final char c) {
        if ((c < NUMBER_START_CHAR) || (c > NUMBER_END_CHAR)) {
            String message = String.format("number must be between %d and %d", NUMBER_START, NUMBER_END);
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateDuplicatedCharacter(final String numbers) {
        HashSet<Character> set = new HashSet<>();
        for (char c : numbers.toCharArray()) {
            set.add(c);
        }
        if (set.size() != NUMBERS_LENGTH) {
            String message = "All numbers must be different";
            throw new IllegalArgumentException(message);
        }
    }

    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(final String numbers) {
        validateNumbers(numbers);
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            char number = numbers.charAt(i);
            this.numbers.add(number - '0');
        }
    }

    public int numberAt(final int index) {
        return numbers.get(index);
    }

    public int indexOf(final int number) {
        return numbers.indexOf(number);
    }
}
