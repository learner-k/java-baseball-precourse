package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JudgementTest {
    @Test
    void testInvalidArguments() {
        assertThatThrownBy(() -> new Judgement(-1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Judgement(4, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Judgement(0, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Judgement(0, 4)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Judgement(1, 3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Judgement(3, 1)).isInstanceOf(IllegalArgumentException.class);
    }
}
