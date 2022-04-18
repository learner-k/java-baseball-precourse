package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @Test
    void testInvalidArguments() {
        // 3자리가 아닌 경우
        assertThatThrownBy(() -> new Numbers("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("12")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("1234")).isInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닌 경우
        assertThatThrownBy(() -> new Numbers("a23")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("1b3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("12c")).isInstanceOf(IllegalArgumentException.class);

        // 중복된 숫자가 있는 경우
        assertThatThrownBy(() -> new Numbers("113")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("122")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("323")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testNumberAt() {
        Numbers numbers = new Numbers("123");
        assertThat(numbers.numberAt(0)).isEqualTo(1);
        assertThat(numbers.numberAt(1)).isEqualTo(2);
        assertThat(numbers.numberAt(2)).isEqualTo(3);
    }
}
