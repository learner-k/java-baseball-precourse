package baseball;

import org.junit.jupiter.api.Test;

import static baseball.Constants.NUMBERS_LENGTH;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RandomNumbersGeneratorTest {
    @Test
    void testGenerate() {
        final Numbers randomNumbers = RandomNumbersGenerator.generate();
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            numbers.append(randomNumbers.numberAt(i));
        }
        assertThatNoException().isThrownBy(() -> Numbers.validateNumbers(numbers.toString()));
    }
}
