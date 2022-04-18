package baseball;

import static baseball.Constants.NUMBERS_LENGTH;

public class Referee {
    private Referee() {
    }

    public static Judgement judge(final Numbers attackNumbers, final Numbers defenseNumbers) {
        int ball = 0;
        int strike = 0;

        for (int attackIndex = 0; attackIndex < NUMBERS_LENGTH; attackIndex++) {
            int attackNumber = attackNumbers.numberAt(attackIndex);
            int defenseIndex = defenseNumbers.indexOf(attackNumber);
            if (attackIndex == defenseIndex) {
                strike++;
                continue;
            }
            if (defenseIndex >= 0) {
                ball++;
            }
        }

        return new Judgement(ball, strike);
    }
}
