package baseball;

import static baseball.Constants.NUMBERS_LENGTH;

public class Judgement {
    static void validateCount(final int ball, final int strike) {
        validateCountRange(ball);
        validateCountRange(strike);
        validateCountSum(ball, strike);
    }

    static void validateCountRange(final int count) {
        if (count < 0 || count > NUMBERS_LENGTH) {
            String message = String.format("Judgement count ranges from 0 to %d", NUMBERS_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    static void validateCountSum(final int ball, final int strike) {
        if (ball + strike > NUMBERS_LENGTH) {
            String message = String.format("sum of ball and strike is greater than %d", NUMBERS_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    private final int ball;
    private final int strike;

    public Judgement(final int ball, final int strike) {
        validateCount(ball, strike);
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return (ball == 0) && (strike == 0);
    }

    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }
        StringBuilder countBuilder = new StringBuilder();
        if (ball > 0) {
            countBuilder.append(String.format("%d볼", ball));
        }
        if ((ball > 0) && (strike > 0)) {
            countBuilder.append(" ");
        }
        if (strike > 0) {
            countBuilder.append(String.format("%d스트라이크", strike));
        }
        return countBuilder.toString();
    }
}
