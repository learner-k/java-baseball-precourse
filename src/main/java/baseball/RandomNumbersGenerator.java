package baseball;

import java.util.HashSet;
import java.util.Set;

import static baseball.Constants.NUMBERS_LENGTH;
import static baseball.Constants.NUMBER_END;
import static baseball.Constants.NUMBER_START;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumbersGenerator {
    private RandomNumbersGenerator() {
    }

    public static Numbers generate() {
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < NUMBERS_LENGTH) {
            numbersSet.add(pickNumberInRange(NUMBER_START, NUMBER_END));
        }
        StringBuilder numbers = new StringBuilder();
        for (Integer number : numbersSet) {
            numbers.append(number.toString());
        }
        return new Numbers(numbers.toString());
    }
}
