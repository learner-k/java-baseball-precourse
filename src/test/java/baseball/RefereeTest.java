package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    static void assertNumbers(final Judgement actual, final Judgement expected) {
        assertThat(actual.getBall()).isEqualTo(expected.getBall());
        assertThat(actual.getStrike()).isEqualTo(expected.getStrike());
        assertThat(actual.isNothing()).isEqualTo(expected.isNothing());
    }

    @Test
    void testJudge() {
        Numbers defense = new Numbers("425");

        Numbers attack0 = new Numbers("123");
        Judgement judgement0 = Referee.judge(attack0, defense);
        assertNumbers(judgement0, new Judgement(0, 1));

        Numbers attack1 = new Numbers("456");
        Judgement judgement1 = Referee.judge(attack1, defense);
        assertNumbers(judgement1, new Judgement(1, 1));

        Numbers attack2 = new Numbers("789");
        Judgement judgement2 = Referee.judge(attack2, defense);
        assertNumbers(judgement2, new Judgement(0, 0));

        Numbers attack3 = new Numbers("425");
        Judgement judgement3 = Referee.judge(attack3, defense);
        assertNumbers(judgement3, new Judgement(0, 3));
    }
}
