package khims.rodion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

    @ParameterizedTest
    @DisplayName("Test successful factorial")
    @CsvSource({"1, 1", "2, 2", "3, 6", "5, 120", "10, 3628800"})
    public void testSuccessfulFactorial(int value, long expected) {
        BigInteger calculated = MathUtils.calcFactorial(value);
        Assertions.assertThat(calculated).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test Zero Value")
    public void testZeroFactorial() {
        BigInteger calculated = MathUtils.calcFactorial(0);
        Assertions.assertThat(calculated).isEqualTo(1);
    }

    @Test
    @DisplayName("Test Negative Value")
    public void testNegativeFactorial() {
        Throwable thrown = Assertions.catchThrowable(() -> MathUtils.calcFactorial(-1));
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect value: -1");
    }
}
